package com.pramodaya.kotlinflows

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel: ViewModel() {

    val countDownFlow = flow<Int> {
        var number = 20
        emit(number)
        while (number > 0){
            delay(1000L)
            number--
            emit(number)
        }
    }
}