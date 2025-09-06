package br.com.etecia.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorProduto extends RecyclerView.Adapter<AdaptadorProduto.ViewHolder> {
    private Context context;
    private List<Produto> lstLoja;

    public AdaptadorProduto(Context context, List<Produto> lstLoja) {
        this.context = context;
        this.lstLoja = lstLoja;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCardLoja;
        private TextView titulo;
        private TextView descricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCardLoja = (ImageView) itemView.findViewById(R.id.imgCardLoja);
            titulo = (TextView) itemView.findViewById(R.id.idTituloLoja);
            descricao = (TextView) itemView.findViewById(R.id.idDescricaoLoja);
        }

        public ImageView getImgCardLoja() {
            return imgCardLoja;
        }

        public TextView getTitulo() {
            return titulo;
        }

        public TextView getDescricao() {
            return descricao;
        }
    }

    @NonNull
    @Override
    public AdaptadorProduto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modelo_produto, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProduto.ViewHolder holder, int position) {
        holder.getTitulo().setText(lstLoja.get(position).getTitulo());
        holder.getDescricao().setText(lstLoja.get(position).getDescricao());
        holder.getImgCardLoja().setImageResource(lstLoja.get(position).getImgProduto());
    }

    @Override
    public int getItemCount() {
        return lstLoja.size();
    }
}
