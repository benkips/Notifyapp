package com.mabnets.notifyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.mabnets.notifyapp.databinding.ActivityMainBinding
import com.mabnets.notifyapp.viewModel.Notiviewmodel
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mabnets.kotstart.data.network.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    val TOPIC="/topics/Alerts"
    private  val viewmodel by viewModels<Notiviewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pgbar.visible(false)
        viewmodel.notiResponse.observe(this, Observer {
            binding.pgbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    this.showPermissionRequestExplanation("Success","Notification was sent")
                }
                is Resource.Failure -> handleApiError(it) {
                }
            }
        })

        binding.send.setOnClickListener {
            val title = binding.title.text.toString()
            val message = binding.msg.text.toString()
            if(title.isNotEmpty() && message.isNotEmpty()) {
                sendstuff(message,title)
            }
        }
    }
    private fun sendstuff(x:String,y:String){
        viewmodel.sendnow(x,y)
    }
}