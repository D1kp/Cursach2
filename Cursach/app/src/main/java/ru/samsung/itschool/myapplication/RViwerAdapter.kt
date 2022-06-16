package ru.samsung.itschool.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.samsung.itschool.myapplication.databinding.MemberItemBinding

class RViwerAdapter(listViewer:ArrayList<String>,val listener: MyOnClickListener):RecyclerView.Adapter<RViwerAdapter.RVHolder>() {
    val listViewer = listViewer

    class RVHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = MemberItemBinding.bind(item)
        fun bind(viewer:String,listener: MyOnClickListener) = with(binding){
            textView6.text = viewer
            itemView.setOnClickListener{
                listener.OnClick(viewer)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViwerAdapter.RVHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.member_item,parent,false)
        return RViwerAdapter.RVHolder(view)
    }

    fun addMember(viewerData:ArrayList<String>){
        for(i in 0 until viewerData.size){
            listViewer.add(viewerData[i])
        }

    }
    override fun getItemCount(): Int {
        return listViewer.size
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
        holder.bind(listViewer[position],listener)
    }

    interface MyOnClickListener{
        fun OnClick(viewer: String)
    }
}