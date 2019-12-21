package com.example.myapplication.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import com.example.myapplication.R;
import com.example.myapplication.ui.share.ApiMaquillageHandler;
import com.example.myapplication.ui.share.Produit;
import com.example.myapplication.ui.share.Produit_adapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;
    private Produit_adapter pa;
    private ArrayList<Produit> liste=new ArrayList<Produit>();
    private RecyclerView rc;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe(this, new Observer<String>() {
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
        ApiBeauteHandler api=rf.create(ApiBeauteHandler.class);
        final Call<ArrayList<Produit>> lister=api.getAllProducts();
        lister.enqueue(new Callback<ArrayList<Produit>>() {
            @Override
            public void onResponse(Call<ArrayList<Produit>> call, Response<ArrayList<Produit>> response) {
                if(response.isSuccessful())
                {
                    liste=(ArrayList<Produit>) response.body();
                    Toast.makeText(getContext(),liste.get(0).toString(),Toast.LENGTH_SHORT).show();
                    pa=new Produit_adapter(liste,getContext());
                    rc.setAdapter(pa);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Produit>> call, Throwable t) {
            }
        });
        rc=(RecyclerView)view.findViewById(R.id.rec_beaute);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getActivity());
        rc.setLayoutManager(lm);
        DividerItemDecoration dvi=new DividerItemDecoration(rc.getContext(),DividerItemDecoration.VERTICAL);
        rc.addItemDecoration(dvi);
        Toast.makeText(getContext(),"liste="+liste.size(),Toast.LENGTH_SHORT).show();

    }
}