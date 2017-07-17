package com.example.ffff.myfirstapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.ffff.myfirstapp.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_list_row_layout.view.*

/**
 * Created by ffff on 7/17/17.
 */
class PhotoListRecyclerViewAdapter(context: Context, var photoList: ArrayList<Photo>) : RecyclerView.Adapter<PhotoListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_list_row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind()
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){
            itemView.ivImageRow.loadImageWithUrl(photoList[adapterPosition].webformatURL)
        }
    }

    fun ImageView.loadImageWithUrl(url:String) {
        Picasso.with(context).load(url).into(this)
    }
}