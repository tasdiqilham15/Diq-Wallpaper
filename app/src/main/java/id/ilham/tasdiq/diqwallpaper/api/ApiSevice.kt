package id.ilham.tasdiq.diqwallpaper.api

import id.ilham.tasdiq.diqwallpaper.model.Detail
import id.ilham.tasdiq.diqwallpaper.model.ImageSearch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiSevice {
    //untuk menentukan base url
    private const val BASE_URL="https://pixabay.com/api/"
    private val api:PixabayApi by lazy {
        //membuat request api dengan base url
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(PixabayApi::class.java)
    }
    //request api dengan ImageSearch
    fun getImages(query:String):Call<ImageSearch>{
        return api.getImage(query)
    }
}