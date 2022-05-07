package com.mabnets.notifyapp.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mabnets.kotstart.data.network.Resource
import com.mabnets.notifyapp.Models.Resultstuff
import com.mabnets.notifyapp.Repository.Repo
import kotlinx.coroutines.launch


class Notiviewmodel @ViewModelInject constructor(private  val repostuff: Repo) : ViewModel() {

    private val _notiResponse: MutableLiveData<Resource<Resultstuff>> = MutableLiveData()
    val notiResponse: LiveData<Resource<Resultstuff>>
        get() = _notiResponse

     fun sendnow(
            msg: String, title: String
    ) = viewModelScope.launch {
        _notiResponse.value = Resource.Loading
        _notiResponse.value= repostuff.sending(msg,title)
    }

}