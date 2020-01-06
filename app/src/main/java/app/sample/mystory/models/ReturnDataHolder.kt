package app.sample.mystory.models

import Models.UserInfo
import com.google.gson.annotations.SerializedName

data class ReturnDataHolder(@SerializedName("count") val count: Int,
                            @SerializedName("user_info") val userStories: ArrayList<UserInfo>)