package com.yoel.corroutineszerotohero

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        lifecycleScope.launch(Dispatchers.IO) {
            val resultado: Response<List<SuperHeroDataResponse>> = retrofit.getSuperheroes()
            withContext(Dispatchers.Main) {
                if (resultado.isSuccessful) {
//                    Log.i("ejemplo1", "$resultado")
//                    Toast.makeText(this@MainActivity, "Funciona", Toast.LENGTH_SHORT).show()
//                    Log.i("ejemplo2", resultado.body().toString())

                    setContent {
                        CorroutinesZeroToHeroTheme {
                            Surface(modifier = Modifier.fillMaxSize()) {
                                resultado.body()?.let { posts ->
                                    PostsList(posts)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PostsList(posts: List<SuperHeroDataResponse>) {
    Column() {
        posts.forEach { post ->
            SuperheroItem(post)
        }
    }
}

@Composable
//
fun SuperheroItem(post: SuperHeroDataResponse) {
    Column() {
        Text(text = "UserId: ${post.userId}")
        Text(text = "ID: ${post.id}")
        Text(text = "Title: ${post.title}")
        Text(text = "Body: ${post.body}")
    }
}

