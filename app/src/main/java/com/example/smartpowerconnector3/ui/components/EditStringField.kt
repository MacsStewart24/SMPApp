package com.example.smartpowerconnector3.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.example.smartpowerconnector3.data.listOfDevices

@Composable
fun EditStringField(value: String, onValueChange: (String)->Unit) {

    TextField(  value = value,
        onValueChange = onValueChange ,
        //Can add a label if you feel like it
        keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number),
        singleLine = true
    )
}

