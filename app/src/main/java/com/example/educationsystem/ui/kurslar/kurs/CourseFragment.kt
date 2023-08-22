package com.example.educationsystem.ui.kurslar.kurs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.educationsystem.R
import com.example.educationsystem.databinding.FragmentCourseBinding
import com.example.educationsystem.ui.kurslar.adapter.FragmentPagerAdapter
import com.example.educationsystem.ui.kurslar.model.CourseData
import com.google.android.material.tabs.TabLayoutMediator


class CourseFragment : Fragment() {
    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseBinding.inflate(layoutInflater)

        val course = arguments?.get("course") as CourseData
        binding.tvCourse.text = course.name

        val fragmentPagerAdapter =
            FragmentPagerAdapter(requireActivity().supportFragmentManager, this.lifecycle)
        binding.viewPager.adapter = fragmentPagerAdapter

        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Ochilgan guruhlar"
                1 -> tab.text = "Ochilayotgan guruhlar"
            }

        }.attach()
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }


}