package com.example.smartpowerconnector3.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptionScreen(
    //_smpUiState: List<SmpUiState>,
    onEditButtonClicked: ()-> Unit,
    onDeleteButtonClicked: ()->Unit
){
    Column{
        Button(onClick = onEditButtonClicked) {
            Text(
                text = "Edit Device",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
        //Spacer(modifier = Modifier.16.dp)
        Button(onClick = onDeleteButtonClicked) {
            Text(
                text = "Delete Device",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}


@Preview
@Composable
fun OptionScreenPreview(){
    OptionScreen(
        onEditButtonClicked={},
        onDeleteButtonClicked={}
    )
}