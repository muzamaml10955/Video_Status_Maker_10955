package com.inspirationappsstudio.videostatusmaker.ui.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inspirationappsstudio.videostatusmaker.Model.CatagoryItem;
import com.inspirationappsstudio.videostatusmaker.R;
import com.inspirationappsstudio.videostatusmaker.viewholder.CatagoryViewHolder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class HomeFragment extends Fragment {
Button love;

    RecyclerView recyclerview;
    DatabaseReference databaseReference;
    FirebaseRecyclerOptions<CatagoryItem> options;
    FirebaseRecyclerAdapter<CatagoryItem, CatagoryViewHolder> adapter;

    // Write a message to the database
   // FirebaseDatabase database = FirebaseDatabase.getInstance();
  //  DatabaseReference myRef = database.getReference("message");


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);
         love = root.findViewById(R.id.lovebutton);



        recyclerview=root.findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("catagorybackground");





        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // myRef.setValue("Hello, World!");
                dispalyfirebasedata();
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
              // custumdialogbox cdd=new custumdialogbox((Activity) getActivity().getApplicationContext());
               // cdd.show();
            }
        });
        return root;


    }

    private void dispalyfirebasedata() {
        options=new FirebaseRecyclerOptions.Builder<CatagoryItem>().setQuery(databaseReference,CatagoryItem.class).build();
        adapter=new FirebaseRecyclerAdapter<CatagoryItem, CatagoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CatagoryViewHolder holder, int position, @NonNull CatagoryItem model) {
                Picasso.get().load(model.getImageurl()).into(holder.i1, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                holder.t1.setText(model.getName());
            }

            @NonNull
            @Override
            public CatagoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_catagory_item,parent,false);
                return new CatagoryViewHolder(view);
            }
        };
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerview.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerview.setAdapter(adapter);
    }

}