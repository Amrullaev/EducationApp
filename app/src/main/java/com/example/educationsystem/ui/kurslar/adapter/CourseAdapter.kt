package com.example.educationsystem.ui.kurslar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.educationsystem.databinding.ItemCourseBinding
import com.example.educationsystem.ui.kurslar.model.CourseData

class CourseAdapter(
    private val list: List<CourseData>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<CourseAdapter.VH>() {
    inner class VH(private val itemCourseBinding: ItemCourseBinding) :
        RecyclerView.ViewHolder(itemCourseBinding.root) {
        fun onBind(courseData: CourseData) {
            itemCourseBinding.tvCourseName.text = courseData.name
            itemCourseBinding.root.setOnClickListener {
                listener.click(courseData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    interface OnClickListener {
        fun click(courseData: CourseData)
    }
}