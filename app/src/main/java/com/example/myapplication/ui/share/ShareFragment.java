package com.example.myapplication.ui.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    private Produit_adapter pa;
    private ArrayList<Produit>liste=new ArrayList<Produit>();
    private RecyclerView rc;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit rf=new Retrofit.Builder().baseUrl("http://192.168.1.6/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiMaquillageHandler api=rf.create(ApiMaquillageHandler.class);
        final Call<ArrayList<Produit>> lister=api.getAllProducts();
        lister.enqueue(new Callback<ArrayList<Produit>>() {
            @Override
            public void onResponse(Call<ArrayList<Produit>> call, Response<ArrayList<Produit>> response) {
                if(response.isSuccessful())
                {
                    liste=(ArrayList<Produit>) response.body();

                    pa=new Produit_adapter(liste,getContext());
                    rc.setAdapter(pa);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Produit>> call, Throwable t) {
            }
        });
        rc=(RecyclerView)view.findViewById(R.id.rec1);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getActivity());
        rc.setLayoutManager(lm);
        DividerItemDecoration dvi=new DividerItemDecoration(rc.getContext(),DividerItemDecoration.VERTICAL);
        rc.addItemDecoration(dvi);
        Toast.makeText(getContext(),"liste="+liste.size(),Toast.LENGTH_SHORT).show();

    }
}