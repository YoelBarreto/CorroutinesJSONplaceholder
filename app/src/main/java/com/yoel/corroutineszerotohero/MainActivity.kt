package com.yoel.corroutineszerotohero

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.yoel.corroutineszerotohero.ui.theme.CorroutinesZeroToHeroTheme
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : ComponentActivity() {

    val retrofit = RetrofitHelper.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CorroutinesZeroToHeroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SuperHeroList()
                }
            }
        }

        lifecycleScope.launch {
            tumama()
            val response: Response<SuperHeroDataResponse> = retrofit.getSuperheroes("a")
            if (response.isSuccessful){
                Log.i("DAM", "FUNCIONO")
            }
        }
    }

    suspend fun tumama(){

    }

}

@Composable
fun SuperHeroList() {
    Text(
        text = "",
        modifier = Modifier
    )
}
