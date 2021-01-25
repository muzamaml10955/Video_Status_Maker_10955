package com.inspirationappsstudio.videostatusmaker;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.inspirationappsstudio.videostatusmaker.Model.CatagoryItem;
import com.inspirationappsstudio.videostatusmaker.viewholder.CatagoryViewHolder;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
RecyclerView recyclerview;
DatabaseReference databaseReference;
FirebaseRecyclerOptions<CatagoryItem> options;
FirebaseRecyclerAdapter<CatagoryItem, CatagoryViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
      //  recyclerview=findViewById(R.id.recyclerview);
       // recyclerview.setHasFixedSize(true);
       // databaseReference= FirebaseDatabase.getInstance().getReference().child("catagorybackground");
        setSupportActionBar(toolbar);
     //   FloatingActionButton fab = findViewById(R.id.fab);
      /*  fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


      /*  options=new FirebaseRecyclerOptions.Builder<CatagoryItem>().setQuery(databaseReference,CatagoryItem.class).build();
        adapter=new FirebaseRecyclerAdapter<CatagoryItem, CatagoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CatagoryViewHolder holder, int position, @NonNull CatagoryItem model) {
                Picasso.get().load(model.getImageurl()).into(holder.i1, new Callback() {
                    @Override
                    public void onSuccess() {
                        
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                holder.t1.setText(model.getName());
            }

            @NonNull
            @Override
            public CatagoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_catagory_item,parent,false);
                return new CatagoryViewHolder(view);
            }
        };
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerview.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerview.setAdapter(adapter);

*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_privacypolicy, R.id.nav_rateus,R.id.nav_shareapp,R.id.nav_moreapp)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {






            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View viewDialog = inflater.inflate(R.layout.custome_dialog_box, null);
            Dialog exitDialog = new Dialog(MainActivity.this, R.style.CustomAlertDialog);
            exitDialog.setContentView(viewDialog);



            WindowManager.LayoutParams layoutParms = new WindowManager.LayoutParams();
            layoutParms.copyFrom(exitDialog.getWindow().getAttributes());
            layoutParms.width = (int) (getResources().getDisplayMetrics().widthPixels * .9);
            layoutParms.height = (int) (getResources().getDisplayMetrics().heightPixels * .3);
           layoutParms.gravity=Gravity.CENTER;
            LinearLayout rate = viewDialog.findViewById(R.id.rate);
          //  LinearLayout more = viewDialog.findViewById(R.id.More);
            LinearLayout exit = viewDialog.findViewById(R.id.ext);
           // LinearLayout share = viewDialog.findViewById(R.id.share);
            LinearLayout cancel = viewDialog.findViewById(R.id.cancel);




       /* View popupView = layoutInflater.inflate(R.layout.index_popviewxml,
                null);
*/

     /*   final PopupWindow popupWindow = new PopupWindow(viewDialog,
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, true);



        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);

        popupWindow.showAtLocation(viewDialog, Gravity.CENTER, 0, 0);
*/







            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();

                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exitDialog.dismiss();

                }
            });


            rate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("" + getPackageName())));

                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("" + getPackageName())));

                    }

                }
            });
          /*  more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                //    String moreApps = getResources().getString(R.string.more_app);
                   // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(moreApps)));
                  //  finish();

                }
            });*/

           /* share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String body = "https://play.google.com/store/apps/developer?id=com.classicappsstudio.mehndistyke";
                    String sub = "Your Subject";
                    intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                    intent.putExtra(Intent.EXTRA_TEXT, body);
                    startActivity(Intent.createChooser(intent, "Share Using"));

                }
            });*/

            exitDialog.setCancelable(true);
            exitDialog.setCanceledOnTouchOutside(false);
            exitDialog.getWindow().setAttributes(layoutParms);
            exitDialog.show();



















    }

   /* @Override
    protected void onStart() {
        super.onStart();
        if(adapter!=null)
            adapter.startListening();
    }

    @Override
    protected void onStop() {
        if(adapter!=null)
            adapter.startListening();
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adapter!=null)
            adapter.startListening();
    }*/
}