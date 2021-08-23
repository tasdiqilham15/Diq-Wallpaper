package id.ilham.tasdiq.diqwallpaper.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Detail(
    val previewURL:String?,
    val largeImageURL:String?,
    val imageWidth:String?,
    val imageHeight:String?,
    val imageSize:String?,
    val views:String?,
    val downloads:String?,
    val likes:String?,
    val user:String?,
    val userImageURL:String?,
    val tags:String?
):Parcelable{
    constructor():this("","","","","","","",
        "","","","")
}

