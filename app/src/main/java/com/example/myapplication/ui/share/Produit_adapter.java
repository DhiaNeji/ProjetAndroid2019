package com.example.myapplication.ui.share;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity_affichage_produit;
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
    public void onBindViewHolder(@NonNull ProduitViewHolder holder, final int position) {
    Produit p=liste.get(position);
    holder.txtLib.setText(p.getLibelle());
    holder.txtMarque.setText(p.getMarque());
    holder.txtPrix.setText(p.getPrix()+" DT");
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(ctx, Activity_affichage_produit.class);
            i.putExtra("Libelle",liste.get(position).getLibelle());
            i.putExtra("Categorie",liste.get(position).getCategorie());
            i.putExtra("Marque",liste.get(position).getMarque());
            i.putExtra("Prix",liste.get(position).getPrix());
            ctx.startActivity(i);
        }
    });
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
