package app.sample.mystory.ui

import Models.UserInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.sample.mystory.R
import app.sample.mystory.adapters.StoryAdapter
import app.sample.mystory.models.ReturnDataHolder
import app.sample.mystory.utils.Constants
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var stories = ArrayList<UserInfo>()
    private lateinit var storiesAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stories = Gson().fromJson(Constants.userInfo, ReturnDataHolder::class.java).userStories

        //we make the recyclerview list horizontal
        storiesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storiesAdapter = StoryAdapter(this, stories)
        storiesList.setHasFixedSize(true)
        storiesList.adapter = storiesAdapter

    }

    fun showStory(storyModel: UserInfo){

    }

}
