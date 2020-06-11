package com.retetamortar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MarcaMortar extends RecyclerView.Adapter<MarcaMortar.mMortarViewHolder>implements View.OnClickListener {
    String[] m_Mortar;
    String mortar_selectat;

    public MarcaMortar(String[] m_Mortar){
        this.m_Mortar = m_Mortar;
    }
    @NonNull
    @Override
    public mMortarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View MortarView = inflater.inflate(R.layout.m_mortar, parent, false);
        MortarView.setOnClickListener(this);
        mMortarViewHolder viewHolder = new mMortarViewHolder(MortarView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull mMortarViewHolder holder, int position) {
        String marca = m_Mortar[position];
        holder.textTipuriDeMortar.setText(marca);

    }

    @Override
    public int getItemCount() {
        return m_Mortar.length;
    }

    @Override
    public void onClick(View v) {
    TextView textMortar = v.findViewById(R.id.textTipuriDeMortar);
    Context context = v.getContext();
    mortar_selectat = textMortar.getText().toString();
    Intent intent = new Intent(context, Reteta.class);
    intent.putExtra("mortarSelectat", mortar_selectat);
    context.startActivity(intent);
    }

    public class mMortarViewHolder extends RecyclerView.ViewHolder{
        TextView textTipuriDeMortar;
        public mMortarViewHolder(@NonNull View itemView) {
            super(itemView);
            textTipuriDeMortar = itemView.findViewById(R.id.textTipuriDeMortar);
        }
    }
}
