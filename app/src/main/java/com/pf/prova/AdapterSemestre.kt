package com.pf.prova

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterSemestre (
    private val context: Context,
    private val semestres: List<Semestre>?,
    private val onClickListener: SemestreOnclickListener) : RecyclerView.Adapter<AdapterSemestre.SemestreViewHolder>(){
        interface  SemestreOnclickListener{
            fun OnclickSemestre(holder: SemestreViewHolder?, idx: Int)
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SemestreViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_adapter_semestre,
            viewGroup, false)
        return SemestreViewHolder(view)
    }

    override fun onBindViewHolder(holder: SemestreViewHolder, position: Int) {
        val semestre = semestres!![position]

        holder.tNome.text = "${semestre.semestre}º semestre ${semestre.ano}"


        holder.itemView.setOnClickListener {
            onClickListener.OnclickSemestre(holder, position)
        }
    }

    override fun getItemCount(): Int = semestres!!.size

    class SemestreViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        var tNome: TextView = view.findViewById(R.id.semestre)
    }
}
