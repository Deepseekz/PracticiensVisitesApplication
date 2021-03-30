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


public class RecyclerViewAdapterVisites extends RecyclerView.Adapter<RecyclerViewAdapterVisites.RecyclerViewHolder> {
    private List<Visiteur> dataModelList;

    public RecyclerViewAdapterVisites(List<Visiteur> dataModelList) {
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
        holder.textViewDate.setText(String.valueOf(dataModelList.get(position).getDateVisite()));
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public long getItemId(int position) {
        return super.getItemId(position);
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDate;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDate = itemView.findViewById(R.id.tvNom);
        }
    }
}