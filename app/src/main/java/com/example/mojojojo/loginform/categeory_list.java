package com.example.mojojojo.loginform;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import de.hdodenhof.circleimageview.CircleImageView;

public class categeory_list extends AppCompatActivity {

    GridView grid1;
    ImageView img1;
    //CircleImageView ci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categeory_list);

        // ci=(CircleImageView)findViewById(R.id.cmenimg);
        grid1 = (GridView) findViewById(R.id.g_catlist);

        String catobj1[] = {"CLOTHES", "WATCHES", "SHOES", "ELECTROICS", "FOOD", "KITCHEN ASSOSARIES", "KIDS TOYS", "BOOKS"};
        int[] testImage = {R.drawable.clothe1, R.drawable.watch2, R.drawable.shoes, R.drawable.electronics, R.drawable.grocerry1, R.drawable.kitchen1, R.drawable.toys, R.drawable.books1};

        My_adapter my_adpt = new My_adapter(this, R.layout.cat_raw, catobj1, testImage);
        grid1.setAdapter(my_adpt);

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0 || i == 1 || i == 3) {

                    Dialog dialog = new Dialog(categeory_list.this);
                    dialog.setContentView(R.layout.cloth_dialog1);
dialog.setTitle("Dhyni");
                    ImageView ln = (ImageView) dialog.findViewById(R.id.cmenimg);
                    ln.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent i1 = new Intent(categeory_list.this, pro_list_men.class);
                            startActivity(i1);

                        }
                    });
                    dialog.show();
                }
            }

        });

    }
}


