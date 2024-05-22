package com.example.myhttpcase.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.myhttpcase.model.MainActivityViewModel
import com.example.myhttpcase.ui.theme.MyHttpCaseTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint//允许被注入
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.items.collect{
                text1 = it
            }
        }
        enableEdgeToEdge()
        setContent {
            MyHttpCaseTheme {
                Greeting(
                    viewModel
                )
            }
        }
    }
}

var text1 by mutableStateOf("我是可变的数据")

@Composable
fun Greeting(viewModel: MainActivityViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Button(
            onClick = { /*点击事件*/
                viewModel.fetchItems()
            },
            colors = ButtonDefaults.buttonColors(
                Color.Red,
            )
        ) {
            Text(
                text = "我是被点的",
            )
        }
        Text(
            text = text1,
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyHttpCaseTheme {
      // Greeting( )
    }
}