package id.ilham.tasdiq.diqwallpaper.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ilham.tasdiq.diqwallpaper.api.ApiSevice
import id.ilham.tasdiq.diqwallpaper.model.Detail
import id.ilham.tasdiq.diqwallpaper.model.ImageSearch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel :ViewModel(){
    private val apiService= ApiSevice
    private val dataImage=MutableLiveData<ArrayList<Detail>>()
    fun setImage (query:String){
        apiService.getImages(query).enqueue(object :Callback<ImageSearch>{
            override fun onResponse(call: Call<ImageSearch>, response: Response<ImageSearch>) {
                if (response.isSuccessful){
                    val imageResponse= response.body()?.hits
                    dataImage.postValue(imageResponse)
                }
            }
            override fun onFailure(call: Call<ImageSearch>, t: Throwable) {
                Log.e("ERROR-RESPONSE",t.message.toString())
            }

        })
    }
    fun getDataImage():LiveData<ArrayList<Detail>>{
        return dataImage
    }
}