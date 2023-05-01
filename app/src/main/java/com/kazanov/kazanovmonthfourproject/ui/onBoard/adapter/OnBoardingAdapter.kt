package com.kazanov.kazanovmonthfourproject.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kazanov.kazanovmonthfourproject.databinding.ItemOnBoardBinding
import com.kazanov.kazanovmonthfourproject.model.OnBoard
import com.kazanov.kazanovmonthfourproject.utils.loadImage
import kotlin.reflect.KFunction1

class OnBoardingAdapter(private val onClick: KFunction1<OnBoard, Unit>) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            title = "Title one",
            desc = "Description one",
            "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"
        ),
        OnBoard(
            title = "Title two",
            desc = "Description two",
            "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"
        ),
        OnBoard(
            title = "Title three",
            desc = "Description three",
            "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))

    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.setOnClickListener {
                onClick(onBoard)
            }

            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            binding.ivBoard.loadImage(onBoard.image)

        }

    }
}