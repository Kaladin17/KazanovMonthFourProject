package com.kazanov.kazanovmonthfourproject.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.kazanov.kazanovmonthfourproject.data.local.Pref
import com.kazanov.kazanovmonthfourproject.databinding.FragmentProfileBinding
import com.kazanov.kazanovmonthfourproject.utils.loadImage

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                val photoUri = it.data?.data
                pref.saveImage(photoUri.toString())
                binding.iconProfile.loadImage(photoUri.toString())
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = Pref(requireContext())
        binding.etProfile.setText(pref.getUserName().toString())
        binding.etProfile.addTextChangedListener {
            pref.saveUserName(binding.etProfile.text.toString())
        }

        binding.iconProfile.loadImage(pref.getImage())
        binding.iconProfile.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch((intent))
        }
    }
}