package app.sample.mystory.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Story(@SerializedName("type") val type: String,
                 @SerializedName("data") val data: String,
                 @SerializedName("views") val views: Int,
                 @SerializedName("date") val date: String,
                 @SerializedName("preview") val preview: String): Serializable