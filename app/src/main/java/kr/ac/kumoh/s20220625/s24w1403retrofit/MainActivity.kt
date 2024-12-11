package kr.ac.kumoh.s20220625.s24w1403retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.ac.kumoh.s20220625.s24w1403retrofit.ui.theme.S24W1403RetrofitTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S24W1403RetrofitTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: SongViewModel = viewModel()) { //viewModel()에 오류날 시에 viewModel() 다시 쓰고 3번째 선택
    val songList by viewModel.songList.observeAsState(emptyList())

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        SongList(
            list = songList,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun SongList(list: List<Song>, modifier: Modifier) {
    LazyColumn(
        modifier,
    ) {
//        item {
//            Text("Header")
//        }
        items(list) { song ->
            Text(list.toString())
        }
//        item {
//            Text("Footer") //이렇게 위 아래에 텍스트(아이템) 넣을 수 있음
//        }
    }
}