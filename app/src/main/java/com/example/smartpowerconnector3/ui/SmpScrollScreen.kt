package com.example.smartpowerconnector3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartpowerconnector3.data.SmpUiState


@Composable
fun SmpScrollScreen(
    _smpUiState: Map<String, SmpUiState>,
    onOptionButtonClicked: () -> Unit = {},
    onDeleteButtonClicked: () -> Unit = {},
    onAddButtonClicked: ()->Unit={},
    modifier: Modifier = Modifier
){
    Column () {
        Row(
            modifier = Modifier.align(Alignment.End),
        ) {
            Button(onClick = onOptionButtonClicked, modifier = Modifier) {
                Text(
                    text = "Edit Device"
                )
            }
            Button(onClick = onAddButtonClicked, modifier = Modifier) {
                Text(
                    text = "Add Device"
                )
            }
        Button(onClick = onDeleteButtonClicked, modifier = Modifier) {
            Text(
                text = "Delete Device"
            )
            }
        }
        _smpUiState.forEach { item ->
            Card(modifier = modifier.padding(1.dp).fillMaxWidth(), elevation = 4.dp) {
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = item.value.DeviceName,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = item.value.DeviceID,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.h6
                    )

                    Button(onClick = {/*Create a function for True or false logic*/ },
                            modifier=Modifier) {
                        Text(
                            text = item.value.TrueOrFalse.toString(),
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun SmpScrollScreenPreview(){
    SmpScrollScreen(_smpUiState = mapOf(
        "1a" to SmpUiState("1a","aa",false),
        "2b" to SmpUiState("2b","bb",true),
    )  , onOptionButtonClicked = {  },
        onAddButtonClicked={}
    )
}