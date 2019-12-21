package com.example.myapplication.ui.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Produit_adapter extends RecyclerView.Adapter<Produit_adapter.ProduitViewHolder> {
private ArrayList<Produit>liste;
private Context ctx;

    public Produit_adapter(ArrayList<Produit> liste, Context ctx) {
        this.liste = liste;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_view_item,parent,false);
        ProduitViewHolder p=new ProduitViewHolder(view);
        return p;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitViewHolder holder, int position) {
    Produit p=liste.get(position);
    holder.txtLib.setText(p.getLibelle());
    holder.txtMarque.setText(p.getMarque());
    holder.txtPrix.setText(p.getPrix()+" DT");
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public static class ProduitViewHolder extends RecyclerView.ViewHolder
{

    TextView txtLib;
    TextView txtMarque;
    TextView txtPrix;
    public ProduitViewHolder(View v)
    {
        super(v);
        this.txtLib=v.findViewById(R.id.txtLib);
        this.txtMarque=v.findViewById(R.id.txtMarque);
        this.txtPrix=v.findViewById(R.id.txtPrix);
    }

}
}
