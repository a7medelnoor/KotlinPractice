package com.a7medelnoor.kotlinPractice.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.kotlinPractice.R
import com.a7medelnoor.kotlinPractice.model.User
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

/*
*  Created By: Ahmed Elnoor
*  Date: 9/14/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/

/*
*  adapter class for the items of the recycler view to inflate the item layout to the main activity layout
*/
class MainAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // bind the user info details name,email,image
        fun bind(user: User) {
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageAvatar.context)
                .load(user.avatar)
                .into(itemView.imageAvatar)

        }
    }

    // inflate the item from item_layout to mainActivity recyclearView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
    )

    // holder bind the users by position
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }

    // count the users size
    override fun getItemCount(): Int = users.size

}