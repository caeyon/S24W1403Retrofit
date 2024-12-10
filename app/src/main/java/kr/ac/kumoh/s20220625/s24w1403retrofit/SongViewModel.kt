package kr.ac.kumoh.s20220625.s24w1403retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SongViewModel : ViewModel() {
    private val songApi: SongApi
    private val _songList = MutableLiveData<List<Song>>()
    val songList: LiveData<List<Song>>
        get() = _songList

    init { //처음에 ViewModel 생길 때 실행됨
        val retrofit = Retrofit.Builder()
            .baseUrl(SongApiConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        songApi = retrofit.create(SongApi::class.java)
        fetchData() //서버의 데이터 가져오는 함수
    }

    private fun fetchData() {
        // Coroutine 사용
        viewModelScope.launch {
            try {
                val response = songApi.getSongs()
                _songList.value = response
            } catch(e: Exception) {
                Log.e("fetchData()", e.toString())
            }
        }
    }
}