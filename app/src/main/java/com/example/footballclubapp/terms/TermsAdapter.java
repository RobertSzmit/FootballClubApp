package com.example.footballclubapp.terms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballclubapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class TermsAdapter extends FirebaseRecyclerAdapter<TermsModel, TermsAdapter.myviewholder> {

    public TermsAdapter(@NonNull FirebaseRecyclerOptions<TermsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull TermsModel TermsModel) {

        holder.teams.setText(TermsModel.getTeams());

        if (holder.teams.getText().toString().contains("_n")) {
            String newTeams = TermsModel.getTeams().replace("_n", "\n");
            holder.teams.setText(newTeams);
        }
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_terms, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView teams;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            teams = itemView.findViewById(R.id.contentText2);
        }
    }
}
