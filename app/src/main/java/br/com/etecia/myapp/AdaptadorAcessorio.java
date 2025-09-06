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

public class AdaptadorAcessorio extends RecyclerView.Adapter<AdaptadorAcessorio.ViewHolder> {
    private Context context;
    private List<Acessorio> lstAcessorio;

    public AdaptadorAcessorio(Context context, List<Acessorio> lstAcessorio) {
        this.context = context;
        this.lstAcessorio = lstAcessorio;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCardAcessorio;
        private TextView titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCardAcessorio = (ImageView) itemView.findViewById(R.id.imgCardAcessorio);
            titulo = (TextView) itemView.findViewById(R.id.idTituloAcessorio);
        }

        public ImageView getImgCardAcessorio() {
            return imgCardAcessorio;
        }

        public TextView getTitulo() {
            return titulo;
        }
    }

    @NonNull
    @Override
    public AdaptadorAcessorio.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modelo_acessorio, parent, false);

        return new AdaptadorAcessorio.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorAcessorio.ViewHolder holder, int position) {
        holder.getTitulo().setText(lstAcessorio.get(position).getTitulo());
        holder.getImgCardAcessorio().setImageResource(lstAcessorio.get(position).getImgMiniatura());
    }

    @Override
    public int getItemCount() {
        return lstAcessorio.size();
    }
}
