package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RecyclerviewItemBinding

/// this class extends RecyclerView.Adapter of type MainAdapter.MainViewHolder
/// this class accepts a type of List<Task> value
class MainAdapter(val taskList: List<Task>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    /// the MainViewHolder class accepts and itemBinding of type RecyclerviewItemBinding,
    /// which is the binding type of our recyclerview_item xml binding
    inner class MainViewHolder(val itemBinding: RecyclerviewItemBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
            fun bindItem(task: Task){
                itemBinding.title.text = task.title
                itemBinding.subTitle.text = task.timeStamp
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        /// this will create an recyclerview_item UI for us for a view
        return MainViewHolder(RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        /// this changes the UI for the newly created view UI
        val task = taskList[position]

        /// this is the method we created in our MainViewHolder class to populate the data
        holder.bindItem(task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}