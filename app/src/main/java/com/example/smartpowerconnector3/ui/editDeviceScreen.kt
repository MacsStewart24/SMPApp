package com.example.smartpowerconnector3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartpowerconnector3.data.SmpUiState
import com.example.smartpowerconnector3.data.listOfDevices
import com.example.smartpowerconnector3.ui.components.EditStringField

@Composable
fun editDeviceScreen(
    onFinishButtonClick: ()-> Unit,
    onCancelButtonClick: ()-> Unit
){
    //val smpUiState: SmpUiState
    var newName by remember { mutableStateOf("") }
    var devID by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(32.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Enter new Device Name: ",//stringResource(id = R.string.device_name),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        EditStringField(value= newName, onValueChange = { newName = it })
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Enter the Device's ID: ",//stringResource(id = R.string.device_name),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        EditStringField(value= devID, onValueChange = { devID = it })
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier, verticalAlignment = Alignment.Bottom ){
            Button(onClick = { listOfDevices[devID] = SmpUiState(DeviceName = newName, DeviceID = devID)}) {
                Text(
                    text = "Edit Device",//stringResource(id = R.string.device_name),
                    fontSize = 24.sp,
                )
            }
            Button(onClick =onFinishButtonClick) {
                Text(
                    text = "Return",//stringResource(id = R.string.device_name),
                    fontSize = 24.sp,
                )
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick =  onCancelButtonClick ) {
                Text(
                    text = "Cancel",//stringResource(id = R.string.device_name),
                    fontSize = 24.sp,
                )
            }
        }
    }
}

//fun Swap(oldName: String, newName: String, newValue: String ){
//    var temp: MutableMap<String, SmpUiState> = listOfDevices
 //   listOfDevices.remove(oldName)
//           listOfDevices[newName] = SmpUiState(newName,newValue,)
//}