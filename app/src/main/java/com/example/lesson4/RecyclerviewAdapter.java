package com.example.lesson4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public RecyclerviewAdapter(Context ct, String s1[], String s2[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }


    @Override
    public RecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);


        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.RecyclerviewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myImage.setImageResource(images[position]);


        holder.mainLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity2.class);
            intent.putExtra("data1",data1[position]);
            intent.putExtra("data2",data2[position]);
            intent.putExtra("myImage",images[position]);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView myText1;
        ImageView myImage;
        ConstraintLayout mainLayout;


        public RecyclerviewHolder(View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.txt_title);
            myImage = itemView.findViewById(R.id.image_icon);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
