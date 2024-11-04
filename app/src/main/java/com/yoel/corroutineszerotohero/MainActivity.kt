package com.yoel.corroutineszerotohero

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.yoel.corroutineszerotohero.ui.theme.CorroutinesZeroToHeroTheme
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CorroutinesZeroToHeroTheme {
                Surface {
                    SuperHeroList()
                }
            }
        }
    }
}

@Composable
fun SuperHeroList() {
    val retrofit = RetrofitHelper.getInstance()
    Text(
        text = "",
        modifier = Modifier
    )
}