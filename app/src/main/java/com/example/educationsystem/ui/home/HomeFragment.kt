package com.example.educationsystem.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.educationsystem.R
import com.example.educationsystem.databinding.FragmentAllCoursesBinding
import com.example.educationsystem.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.allCourses.setOnClickListener {
            findNavController().navigate(R.id.allCoursesFragment)
        }
        return binding.root
    }

}