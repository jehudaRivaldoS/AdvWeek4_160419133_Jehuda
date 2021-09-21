package com.example.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.model.Student
import com.example.advweek4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.*

class StudentlistAdapter(val studenList: ArrayList<Student>):RecyclerView.Adapter<StudentlistAdapter.StudentViewHolder>(){
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateStudentList(newStudentList: List<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtIdD.text = studenList[position].id
        holder.view.txtNameCard.text = studenList[position].name.toString()
        holder.view.imageView.loadImage(studenList[position].photoUrl.toString(), holder.view.progressBar)

        holder.view.btnDetail.setOnClickListener {
            val id = studenList[position].id.toString()
            val action = StudentListFragmentDirections.actionStudentDetail(id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return  studenList.size
    }
}