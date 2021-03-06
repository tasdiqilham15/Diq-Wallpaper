package id.ilham.tasdiq.diqwallpaper.api

import id.ilham.tasdiq.diqwallpaper.model.ImageSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi{// menjadi  https://pixabay.com/api/?key=23039768-fd68191fd26f01c53d3429bda
    @GET("?key=23039768-fd68191fd26f01c53d3429bda")
// fungsi mengambil data api dari url https://pixabay.com/api/?key=23039768-fd68191fd26f01c53d3429bda dengan query
    fun getImage(@Query("q") query: String):Call<ImageSearch>
}