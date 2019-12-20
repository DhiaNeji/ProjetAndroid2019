package com.example.myapplication.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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

import java.util.ArrayList;

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
        liste.add(new Produit("xx","aa","zz"));
        liste.add(new Produit("cc","qdsy","yqdsy"));
        liste.add(new Produit("aca","aaa","aaxw"));
        rc=(RecyclerView)view.findViewById(R.id.rec1);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getActivity());
        rc.setLayoutManager(lm);
        DividerItemDecoration dvi=new DividerItemDecoration(rc.getContext(),DividerItemDecoration.VERTICAL);
        rc.addItemDecoration(dvi);
        pa=new Produit_adapter(liste,getContext());
        rc.setAdapter(pa);
    }
}