package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Models.Visiteur;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activities.R;

import java.util.List;


public class RecyclerViewAdapterVisiteurs extends RecyclerView.Adapter<RecyclerViewAdapterVisiteurs.RecyclerViewHolder> {
    private List<Visiteur> dataModelList;

    public RecyclerViewAdapterVisiteurs(List<Visiteur> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_visiteur, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textViewNomPrenom.setText(String.valueOf(dataModelList.get(position).getNom()) + " " + String.valueOf(dataModelList.get(position).getPrenom()));
        holder.textViewMail.setText(dataModelList.get(position).getMail());
        holder.textViewMatricule.setText(dataModelList.get(position).getMatricule());
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public long getItemId(int position) {
        return super.getItemId(position);
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNomPrenom, textViewMail, textViewMatricule;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNomPrenom = itemView.findViewById(R.id.tvNomPrenom);
            textViewMail = itemView.findViewById(R.id.tvMail);
            textViewMatricule = itemView.findViewById(R.id.tvMatricule);
        }
    }
}