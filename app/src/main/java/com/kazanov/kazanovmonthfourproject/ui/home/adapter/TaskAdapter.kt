package com.kazanov.kazanovmonthfourproject.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kazanov.kazanovmonthfourproject.databinding.ItemTaskBinding
import com.kazanov.kazanovmonthfourproject.model.Task

class TaskAdapter(
    private val onLongClick: (task: Task)->Unit, private val onClick: (task: Task)->Unit):
    RecyclerView.
    Adapter<TaskAdapter.TaskViewHolder>() {

    private val data = arrayListOf<Task>()

    fun addTasks(task: List<Task>) {
        data.clear()
        data.addAll(task)
        data.reverse()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
            itemView.setOnLongClickListener{
                onLongClick(task)
                false
            }
            itemView.setOnClickListener {
                onClick(task)
            }
        }
    }
}