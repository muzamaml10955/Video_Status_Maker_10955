package com.inspirationappsstudio.videostatusmaker.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inspirationappsstudio.videostatusmaker.R;

public class CatagoryViewHolder extends RecyclerView.ViewHolder  {
    public TextView t1;
    public ImageView i1;

    public CatagoryViewHolder(@NonNull View itemView) {
        super(itemView);
         t1=(TextView) itemView.findViewById(R.id.name);
         i1=(ImageView) itemView.findViewById(R.id.image);
    }
}
