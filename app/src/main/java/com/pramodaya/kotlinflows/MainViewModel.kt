package com.pramodaya.kotlinflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val getRandomNumberFlow = flow<Int>{
        while (true){
            delay(1000L)
            val number = (0..10).random()
            emit(number)
        }

    }
    init {
        collectFlow()
    }
    private fun collectFlow(){
        viewModelScope.launch {
            getRandomNumberFlow.collect{
                delay(10000L)
                println("Hello world $it")
            }
        }
    }

    

}