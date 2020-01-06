package app.sample.mystory.adapters

import Models.UserInfo
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import app.sample.mystory.R
import app.sample.mystory.ui.MainActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class StoryAdapter(private val ctx: Context, private val storiesList: ArrayList<UserInfo>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item, parent, false)
        return StoryViewHolder(view, ctx)
    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = storiesList[position]

        holder.userNameView.text = story.userName

        //load the user image with glide
        Glide.with(ctx)
            .load(story.profilePicture)
            .apply(RequestOptions().transform(RoundedCorners(6)).placeholder(R.drawable.ic_launcher_background))
            .into(holder.userImage)

        //load the preview image of the first story. Glide will show a default image when the preview is null :)
        Glide.with(ctx)
            .load(story.stories[0].preview)
            .apply(RequestOptions().transform(RoundedCorners(1)).placeholder(R.drawable.ic_launcher_background))
            .into(holder.userImage)

        //show the clicked story
        holder.storyItemView.setOnClickListener {
            (ctx as MainActivity).showStory(story)
        }

    }

    inner class StoryViewHolder constructor(itemView: View, ctx: Context): RecyclerView.ViewHolder(itemView) {
        var storyPreview: ImageView = itemView.findViewById(R.id.storyPreview)
        var userImage: ImageView = itemView.findViewById(R.id.userImage)
        var userNameView: TextView = itemView.findViewById(R.id.userNameView)
        var storyItemView: ConstraintLayout = itemView.findViewById(R.id.storyItemView)
    }

}