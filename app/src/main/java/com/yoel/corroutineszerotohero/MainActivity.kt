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
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.yoel.corroutineszerotohero.ui.theme.CorroutinesZeroToHeroTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val retrofit = RetrofitHelper.getInstance()
        lifecycleScope.launch() {
            val resultado :Response<SuperHeroDataResponse> = retrofit.getSuperheroes("a")
            withContext(Dispatchers.Main){
                if (resultado.isSuccessful){
                    Log.i("ejemplo", "${resultado}")
                }
            }
        }
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
    Text(
        text = "",
        modifier = Modifier
    )
}