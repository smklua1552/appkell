package br.com.etecia.myapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

public class AcessoriosFragment extends Fragment {
    private RecyclerView acessorioRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acessorios, container, false);

        acessorioRecyclerView = (RecyclerView) view.findViewById(R.id.acessorioRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());

        acessorioRecyclerView.setLayoutManager(layoutManager);

        var adapter = new AdaptadorAcessorio(getContext(), List.of(
                new Acessorio("Colar do Eren", R.drawable.eren_colar),
                new Acessorio("Pingente do Armin Arlert", R.drawable.armin_acessorio),
                new Acessorio("Cachecol da Mikasa Ackerman", R.drawable.cachicol_mikasa)
        ));

        acessorioRecyclerView.setAdapter(adapter);

        var toolbar = (MaterialToolbar) getActivity().findViewById(R.id.idToolbar);
        toolbar.setTitle("Acessórios");

        return view;
    }
}