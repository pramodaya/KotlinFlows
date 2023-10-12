package com.pramodaya.kotlinflows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pramodaya.kotlinflows.ui.theme.KotlinFlowsTheme
import kotlinx.coroutines.flow.collect

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinFlowsTheme {

                val viewModel = viewModel<MainViewModel>()
                val randomNumber = viewModel.getRandomNumberFlow.collectAsState(initial = 0)
                Box(modifier = Modifier.fillMaxSize()){
                    Text(
                        text = randomNumber.value.toString(),
                        fontSize = 30.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

            }
        }
    }
}
