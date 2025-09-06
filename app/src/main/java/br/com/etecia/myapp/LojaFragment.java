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

public class LojaFragment extends Fragment {
    private RecyclerView lojaRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loja, container, false);

        lojaRecyclerView = view.findViewById(R.id.lojaRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());

        lojaRecyclerView.setLayoutManager(layoutManager);

        var adapter = new AdaptadorProduto(List.of(
                new Produto("Attack on Titan 34", "O Estrondo esmagou as terras além da Ilha Paradis e tomou inúmeras vidas. Por um lado Armin, Mikasa e os outros descobrem em qual ponto devem atacar Eren. Inimigos, aliados, companheiros e tantas vidas perdidas depois, eles finalmente conseguem chegar até Eren.", R.drawable.aot),
                new Produto("Attack on Titan 33", "Eren dá continuidade ao Estrondo para destruir todas as terras além da Ilha Paradis. Para alcançá-lo, Mikasa, Armin e o grupo vão para a cidade de Odiha onde a aeronave poderá ser preparada. Porém, o preço a ser pago será desistir de Revelio, a cidade onde as famílias do grupo de Annie e Reiner vivem...", R.drawable.aot33),
                new Produto("Attack on Titan 32", "Para proteger a paz da Ilha Paradis, Eren decide exterminar a humanidade fora da ilha com o poder do Titã Fundador. Ele inicia seu ataque, seguido por inúmeros titãs. Serão eles heróis ou demônios? Sem chegar a uma conclusão, Mikasa, Armin e o resto do grupo se preparam para salvar o mundo.", R.drawable.aot32)
        ));

        lojaRecyclerView.setAdapter(adapter);

        var toolbar = (MaterialToolbar) getActivity().findViewById(R.id.idToolbar);
        toolbar.setTitle("Loja");

        return view;
    }
}