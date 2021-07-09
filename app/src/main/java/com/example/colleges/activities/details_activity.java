package com.example.colleges.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.colleges.R;

public class details_activity extends AppCompatActivity {

    private TextView name;
    private TextView country;
    private TextView state;
    private TextView webpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.name_details);
        country = findViewById(R.id.country_details);
        state = findViewById(R.id.state_details);
        webpage = findViewById(R.id.webpages_details);
        Intent i = getIntent();
        name.setText(i.getStringExtra("name"));
        country.setText(i.getStringExtra("country"));
        webpage.setText(i.getStringArrayListExtra("webpage").get(0));

        //CHECKING IF STATE IS NULL ////

        if(i.getStringExtra("state")!=null){
            state.setText(i.getStringExtra("state"));
        }
        else {
            state.setText("STATE NOT AVAILABLE");
        }

        //INSERTING WEBPAGE AS HYPERLINK //

        webpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = webpage.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                v.getContext().startActivity(intent);
            }
        });
    }
}