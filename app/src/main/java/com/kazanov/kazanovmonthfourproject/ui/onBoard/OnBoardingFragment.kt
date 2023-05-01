package com.kazanov.kazanovmonthfourproject.ui.onBoard

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kazanov.kazanovmonthfourproject.databinding.FragmentOnBoardingBinding
import com.kazanov.kazanovmonthfourproject.model.OnBoard
import com.kazanov.kazanovmonthfourproject.ui.onBoard.adapter.OnBoardingAdapter
import me.relex.circleindicator.CircleIndicator3


class OnBoardingFragment : Fragment() {

    lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardingAdapter(this::onClick)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

    private fun onClick(onBoard: OnBoard) {
        findNavController().navigateUp()

    }

}