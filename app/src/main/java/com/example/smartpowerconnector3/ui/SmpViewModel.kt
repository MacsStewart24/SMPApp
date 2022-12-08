package com.example.smartpowerconnector3.ui

import androidx.lifecycle.ViewModel
import com.example.smartpowerconnector3.data.SmpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class SmpViewModel : ViewModel(){
    private val _uiState= MutableStateFlow(SmpUiState())
    val uiState: StateFlow<SmpUiState> = _uiState.asStateFlow()


    fun setDeviceName(newDeviceName: String){
        _uiState.update { currentState->
            currentState.copy(DeviceName=newDeviceName)
        }
    }

    fun setDeviceId(newDeviceId: String){
        _uiState.update { currentState->
            currentState.copy(DeviceID = newDeviceId)
        }
    }

    fun setDeviceStatus(newTrueOrFalse: Boolean){
        _uiState.update { currentState->
            currentState.copy(TrueOrFalse = newTrueOrFalse)
        }
    }
}