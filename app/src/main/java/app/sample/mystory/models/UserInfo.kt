package Models

import app.sample.mystory.models.Story
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserInfo(@SerializedName("names") val userName: String,
                    @SerializedName("profile_picture") val profilePicture: String,
                    @SerializedName("stories") val stories: ArrayList<Story>) : Serializable