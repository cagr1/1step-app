package com.gallardoromero.carlos.gallardo.a1step.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gallardoromero.carlos.gallardo.a1step.R
import com.gallardoromero.carlos.gallardo.a1step.models.Habit

class HabitAdapter (
    private var habits: List<Habit>,
    private val onHelpClick: (Habit) -> Unit
):RecyclerView.Adapter<HabitAdapter.HabitViewHolder>(){
    inner class HabitViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById(R.id.tvHabitName)
        val btnHelp: Button = view.findViewById(R.id.btnHelp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_habit,parent,false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = habits[position]
        holder.tvName.text = habit.name
        holder.btnHelp.setOnClickListener { onHelpClick(habit) }
    }

    override fun getItemCount(): Int = habits.size

    fun updateData(newHabits: List<Habit>) {
        habits = newHabits
        notifyDataSetChanged()
    }
}