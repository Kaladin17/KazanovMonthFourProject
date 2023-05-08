package com.kazanov.kazanovmonthfourproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kazanov.kazanovmonthfourproject.App
import com.kazanov.kazanovmonthfourproject.R
import com.kazanov.kazanovmonthfourproject.databinding.FragmentHomeBinding
import com.kazanov.kazanovmonthfourproject.model.Task
import com.kazanov.kazanovmonthfourproject.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = TaskAdapter(this::onLongClick, this::onClick)

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

    private fun onLongClick(task: Task){
        val aboutDialog: AlertDialog = AlertDialog.Builder(requireContext())
            .setMessage("Delete?")
            .setNegativeButton("cancel") { dialog, which ->
                dialog.cancel()
            }
            .setPositiveButton("OK") { dialog, which ->

                App.db.taskDao().delete(task)
                val list = App.db.taskDao().getAll()
                adapter.addTasks(list)
            }.create()

        aboutDialog.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        val list = App.db.taskDao().getAll()
        adapter.addTasks(list)
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }
    }

    private fun onClick(task: Task){
        findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToTaskFragment(task))
    }


}