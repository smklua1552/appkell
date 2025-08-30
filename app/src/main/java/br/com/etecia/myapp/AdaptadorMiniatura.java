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

public class AdaptadorMiniatura extends RecyclerView.Adapter<AdaptadorMiniatura.ViewHolder> {
    private Context context;
    private List<Miniatura> lstMiniatura;

    public AdaptadorMiniatura(Context context, List<Miniatura> lstMiniatura) {
        this.context = context;
        this.lstMiniatura = lstMiniatura;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCardMiniatura;
        private TextView titulo;
        private TextView descricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCardMiniatura = (ImageView) itemView.findViewById(R.id.imgCardMiniatura);
            titulo = (TextView) itemView.findViewById(R.id.idTituloMiniatura);
            descricao = (TextView) itemView.findViewById(R.id.idDescricaoMiniatura);
        }

        public ImageView getImgCardMiniatura() {
            return imgCardMiniatura;
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
    public AdaptadorMiniatura.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modelo_miniatura, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMiniatura.ViewHolder holder, int position) {
        holder.getTitulo().setText(lstMiniatura.get(position).getTitulo());
        holder.getDescricao().setText(lstMiniatura.get(position).getDescricao());
        holder.getImgCardMiniatura().setImageResource(lstMiniatura.get(position).getImgMiniatura());
    }

    @Override
    public int getItemCount() {
        return lstMiniatura.size();
    }
}
