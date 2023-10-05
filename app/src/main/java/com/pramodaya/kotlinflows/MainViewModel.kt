package com.pramodaya.kotlinflows

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel: ViewModel() {

    val countDownFlow = flow<Int> {
        val startingValue = 20
        var currentValue = startingValue
        while (currentValue > 0){
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }
}