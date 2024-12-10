package kr.ac.kumoh.s20220625.s24w1403retrofit

data class Song( //val 사용->값 변경 불가능
    val id: Int,
    val title: String,
    val singer: String,
    val rating: Int,
    val lyrics: String?
)
