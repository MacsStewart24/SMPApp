package com.example.smartpowerconnector3.data

import androidx.compose.runtime.mutableStateListOf
import com.example.smartpowerconnector3.R

data class SmpUiState(
        val DeviceName: String = "",
        val DeviceID: String = "",
        //val DeviceStatus: String = "",
        val TrueOrFalse: Boolean = false
)
