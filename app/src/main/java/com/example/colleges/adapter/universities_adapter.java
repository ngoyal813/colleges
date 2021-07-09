package com.example.colleges.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colleges.R;
import com.example.colleges.activities.details_activity;
import com.example.colleges.models.model;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class universities_adapter extends RecyclerView.Adapter<universities_adapter.viewholder> {

    public universities_adapter(Context context, List<model> universities_list) {
        this.context = context;
        this.universities_list = universities_list;
    }

    private Context context;

    public void setUniversities_list(List<model> universities_list) {
        this.universities_list = universities_list;
        notifyDataSetChanged();
    }

    private List<model> universities_list;

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewholder holder, int position) {
        holder.name.setText(this.universities_list.get(position).getName());
        holder.country.setText(this.universities_list.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        if(this.universities_list != null){
            return this.universities_list.size();
        }
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView country;
        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =  new Intent(v.getContext(), details_activity.class);
                    intent.putExtra("country",universities_list.get(getAdapterPosition()).getCountry());
                    intent.putExtra("name",universities_list.get(getAdapterPosition()).getName());
                    intent.putExtra("webpage",universities_list.get(getAdapterPosition()).getWeb_pages());
                    intent.putExtra("state",universities_list.get(getAdapterPosition()).getState());
                    v.getContext().startActivity(intent);

                }
            });
            name = itemView.findViewById(R.id.university_name);
            country = itemView.findViewById(R.id.country);
        }
    }
}
