package com.example.footballclubapp.news;

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

public class NewsAdapter extends FirebaseRecyclerAdapter<NewsModel, NewsAdapter.myviewholder> {

    public NewsAdapter(@NonNull FirebaseRecyclerOptions<NewsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull NewsModel NewsModel) {

        holder.title.setText(NewsModel.getTitle());
        holder.content.setText(NewsModel.getContent());
        Glide.with(holder.image.getContext()).load(NewsModel.getImage()).into(holder.image);

        if(holder.title.getText().toString().contains("_n")){   // "Enter" in database
            String newName = NewsModel.getTitle().replace("_n","\n");
            holder.title.setText(newName);
        }

        if(holder.content.getText().toString().contains("_n")){
            String newName = NewsModel.getContent().replace("_n","\n");
            holder.content.setText(newName);
        }
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_news, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, content;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img1);
            title = itemView.findViewById(R.id.titleText);
            content = itemView.findViewById(R.id.contentText);
        }
    }

}

