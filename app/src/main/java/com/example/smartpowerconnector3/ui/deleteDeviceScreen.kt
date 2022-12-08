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

//import com.example.smartpowerconnector3.ui.components.EditStringField

@Composable
fun deleteDeviceScreen(
    OnFinishButtonClick: ()-> Unit,
    onCancelButtonClick: ()-> Unit
){
    var delName by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(32.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Enter Device ID:",//stringResource(id = R.string.device_id),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        EditStringField(value = delName, onValueChange = {delName=it})
        Row(modifier = Modifier, verticalAlignment = Alignment.Bottom ){
            Button(onClick = {listOfDevices.remove(delName) }) {
                Text(
                    text = "Confirm Deletion",//stringResource(id = R.string.device_name),
                    fontSize = 24.sp,
                )
            }
            Button(onClick =  OnFinishButtonClick) {
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