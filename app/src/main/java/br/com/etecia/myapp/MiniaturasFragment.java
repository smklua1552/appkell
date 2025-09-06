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

public class MiniaturasFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_miniaturas, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        var adapter = new AdaptadorMiniatura(getContext(), List.of(
                new Miniatura("Eren Yeager", "Protagonista da série Shingeki no Kyojin", R.drawable.eren),
                new Miniatura("Armin Arlert", "Amor do Eren", R.drawable.armin),
                new Miniatura("Mikasa Ackerman", "Amigo do Eren", R.drawable.mikasa)
        ));

        recyclerView.setAdapter(adapter);

        var toolbar = (MaterialToolbar) getActivity().findViewById(R.id.idToolbar);
        toolbar.setTitle("Miniaturas");

        return view;
    }
}