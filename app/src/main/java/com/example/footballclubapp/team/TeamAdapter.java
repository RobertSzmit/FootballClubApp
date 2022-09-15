package com.example.footballclubapp.team;

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

public class TeamAdapter extends FirebaseRecyclerAdapter<TeamModel, TeamAdapter.myviewholder> {

    public TeamAdapter(@NonNull FirebaseRecyclerOptions<TeamModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull TeamModel TeamModel) {

        holder.player.setText(TeamModel.getPlayer());
        Glide.with(holder.image.getContext()).load(TeamModel.getImage()).into(holder.image);

        if(holder.player.getText().toString().contains("_n")){
            String newPlayer = TeamModel.getPlayer().replace("_n","\n");
            holder.player.setText(newPlayer);
        }
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_team, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView player;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img3);
            player = itemView.findViewById(R.id.contentText3);
        }
    }
}

