package com.example.smartpowerconnector3.data

import androidx.compose.runtime.mutableStateListOf
import com.example.smartpowerconnector3.R



class DataSource(){
    fun loadSmpDevices():  List<SmpUiState>{
        return listOf<SmpUiState>(
            SmpUiState(R.string.name1.toString(), R.string.id_1.toString(),  TrueOrFalse = false)
        )
    }
}

object Data{
    val mpUiState = SmpUiState(R.string.name1.toString(), R.string.id_1.toString(),  TrueOrFalse = false)
}

