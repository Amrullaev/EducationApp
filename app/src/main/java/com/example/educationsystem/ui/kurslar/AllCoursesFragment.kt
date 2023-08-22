package com.example.educationsystem.ui.kurslar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.educationsystem.R
import com.example.educationsystem.databinding.FragmentAllCoursesBinding
import com.example.educationsystem.ui.kurslar.adapter.CourseAdapter
import com.example.educationsystem.ui.kurslar.model.CourseData


class AllCoursesFragment : Fragment() {
    private var _binding: FragmentAllCoursesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllCoursesBinding.inflate(layoutInflater)
        val courseAdapter = CourseAdapter(prevList(), object : CourseAdapter.OnClickListener {
            override fun click(courseData: CourseData) {
                val bundle = Bundle()
                bundle.putSerializable("course", courseData)
                findNavController().navigate(R.id.courseFragment, bundle)
            }

        })
        binding.rv.adapter = courseAdapter

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }


    private fun prevList(): ArrayList<CourseData> {
        val list = ArrayList<CourseData>()
        list.add(CourseData("Android"))
        list.add(CourseData("Frontend"))
        list.add(CourseData("Java"))
        list.add(CourseData("Database"))
        list.add(CourseData("Spring"))
        list.add(CourseData("Python"))
        list.add(CourseData("iOS"))
        list.add(CourseData("Flutter"))



        return list
    }
}