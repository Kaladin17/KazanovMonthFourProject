package com.kazanov.kazanovmonthfourproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.kazanov.kazanovmonthfourproject.R
import com.kazanov.kazanovmonthfourproject.databinding.FragmentHomeBinding
import com.kazanov.kazanovmonthfourproject.ui.Task
import com.kazanov.kazanovmonthfourproject.ui.home.adapter.TaskAdapter
import com.kazanov.kazanovmonthfourproject.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root ?:binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setFragmentResultListener(TaskFragment.TASK_REQUEST) { key, bundle ->
            val result = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            adapter.addTask(result)
        }
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }
    }
}