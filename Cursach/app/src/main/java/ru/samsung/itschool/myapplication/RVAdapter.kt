package ru.samsung.itschool.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ru.samsung.itschool.myapplication.databinding.MemberItemBinding

class RVAdapter(memberslist:ArrayList<Member>,val listener:MyOnClickListener):RecyclerView.Adapter<RVAdapter.RVHolder>() {
    val memberlist = memberslist

    class RVHolder(item:View):RecyclerView.ViewHolder(item) {
        val binding = MemberItemBinding.bind(item)
        fun bind(member:Member,listener:MyOnClickListener) = with(binding){
            textView6.text = member.komand
            itemView.setOnClickListener{
                listener.OnClick(member)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.member_item,parent,false)
        return RVHolder(view)
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
        holder.bind(memberlist[position],listener)
    }

    override fun getItemCount(): Int {
        return memberlist.size
    }

    fun addMember(dataBase:ArrayList<String>){
        var member:Member
        for(i in 0 until dataBase.size){
            member = Member(null.toString(),dataBase[i])
            memberlist.add(member)
        }

    }
    interface MyOnClickListener{
        fun OnClick(member:Member)
    }
 }
