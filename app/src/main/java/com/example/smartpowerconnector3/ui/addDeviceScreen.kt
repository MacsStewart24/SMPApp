package com.example.smartpowerconnector3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartpowerconnector3.data.SmpUiState
import com.example.smartpowerconnector3.data.listOfDevices
import com.example.smartpowerconnector3.ui.components.EditStringField

@Composable
fun addDevice(
    //deviceName : String,
    onFinishButtonClick: ()-> Unit,
    onCancelButtonClick: ()-> Unit
){

    //val smpUiState: SmpUiState
    var newName by remember { mutableStateOf("") }
    var newID by remember { mutableStateOf("") }
    val bool = false

    Column(modifier = Modifier.padding(32.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Enter Device Name: ",//stringResource(id = R.string.device_name),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        EditStringField(value= newName, onValueChange = { newName = it })
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Enter Device ID:",//stringResource(id = R.string.device_id),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        EditStringField(value= newID, onValueChange = { newID= it })
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier, verticalAlignment = Alignment.Bottom ){
            Button(onClick = { listOfDevices.put( "$newID" ,SmpUiState(newName, newID, bool)) // Fixme: Either add another button or figure out how to do both steps in one
                }
                ) {
                    Text(
                    text = "Add Device",//stringResource(id = R.string.device_name),
                    fontSize = 24.sp,
                    )
             }
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick =  onFinishButtonClick) {
                Text(
                    text = "Return",//stringResource(id = R.string.device_name),
                    fontSize = 24.sp,
                )
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick =  onCancelButtonClick) {
                Text(
                    text = "Cancel",//stringResource(id = R.string.device_name),
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun AddDevicePreview(){
    addDevice(
                onFinishButtonClick ={} ,
                onCancelButtonClick = {})
    }