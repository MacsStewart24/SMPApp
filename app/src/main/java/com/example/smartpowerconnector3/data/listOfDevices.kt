package com.example.smartpowerconnector3.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import com.example.smartpowerconnector3.R

var listOfDevices: MutableMap<String, SmpUiState> = mutableStateMapOf(
    "dd" to SmpUiState("dd", R.string.id_1.toString(), TrueOrFalse = false)
)

