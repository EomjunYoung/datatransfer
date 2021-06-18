package com.example.datatransfer

import androidx.lifecycle.ViewModel

//fragment간의 데이터공유는 뷰모델을 통해 가능하다
class MainViewModel: ViewModel() {
     var data: String = ""
}