package com.example.smartpowerconnector3


import androidx.annotation.StringRes

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.stringResource
import com.example.smartpowerconnector3.ui.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartpowerconnector3.data.SmpUiState
import com.example.smartpowerconnector3.data.listOfDevices


enum class DeviceScreen(@StringRes val title: Int){
    Start(title= R.string.known_devices),
    Add(title = R.string.add_device ),
    //Option(title = R.string.option),
    Delete(title= R.string.delete_device),
    Edit(title = R.string.edit_device)
}

@Composable
fun DeviceAppBar(
    currentScreen: DeviceScreen,
    canNavigateBack: Boolean,
    navigateUp: () ->Unit,
    modifier: Modifier=Modifier
){
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun SmpApp(
    modifier: Modifier,
    viewModel : SmpViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = DeviceScreen.valueOf(
        backStackEntry?.destination?.route ?: DeviceScreen.Start.name
    )

    Scaffold(
        topBar = {
            DeviceAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
       val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = DeviceScreen.Start.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = DeviceScreen.Start.name) {
                SmpScrollScreen(
                    _smpUiState= listOfDevices,
                    onOptionButtonClicked = {navController.navigate(DeviceScreen.Edit.name)},
                    onAddButtonClicked    = {navController.navigate(DeviceScreen.Add.name)},
                    onDeleteButtonClicked = {navController.navigate(DeviceScreen.Delete.name)}
                )
            }
            composable(route = DeviceScreen.Add.name) {
                val context = LocalContext.current
                addDevice(
                    onCancelButtonClick= {cancelOrderAndNavigateToStart(viewModel, navController)},
                    onFinishButtonClick= { navController.navigate(DeviceScreen.Start.name) }

                )
            }
           // composable(route = DeviceScreen.Option.name) {
               // val context = LocalContext.current
               // OptionScreen(
                    //Remember to pass the current smpUiState in the the list
                    //_smpUiState= listOfDevices,
                   // onEditButtonClicked   = { navController.navigate(DeviceScreen.Edit.name) },
                    //onDeleteButtonClicked = { navController.navigate(DeviceScreen.Delete.name)},
               // )
           // }
            composable(route = DeviceScreen.Delete.name) {
                val context = LocalContext.current
                deleteDeviceScreen(
                    onCancelButtonClick= {cancelOrderAndNavigateToStart(viewModel, navController)},
                    OnFinishButtonClick = { navController.navigate(DeviceScreen.Start.name) }
                )
            }
            composable(route = DeviceScreen.Edit.name) {
                val context = LocalContext.current
                editDeviceScreen(
                    onCancelButtonClick = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },
                    onFinishButtonClick = { navController.navigate(DeviceScreen.Start.name) }
                )
            }
        }
    }
}


private fun cancelOrderAndNavigateToStart(
    viewModel: SmpViewModel,
    navController: NavHostController
) {
    //viewModel.resetOrder()    // You will need this later!
    navController.popBackStack(DeviceScreen.Start.name, inclusive = false)
}