package com.example.footballclubapp.table;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.footballclubapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TableAdapter extends FirebaseRecyclerAdapter<TableModel, TableAdapter.myviewholder> {

    public TableAdapter(@NonNull FirebaseRecyclerOptions<TableModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull TableModel TableModel) {

        holder.team.setText(TableModel.getTeam());
        Glide.with(holder.image.getContext()).load(TableModel.getImage()).into(holder.image);

        if(holder.team.getText().toString().contains("_n")){
            String newTeam = TableModel.getTeam().replace("_n","\n");
            holder.team.setText(newTeam);
        }
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_table, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView team;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img2);
            team = itemView.findViewById(R.id.contentText1);
        }
    }

}
