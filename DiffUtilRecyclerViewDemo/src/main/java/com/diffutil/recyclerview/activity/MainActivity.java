package com.diffutil.recyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.diffutil.recyclerview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_1, tv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_1.setOnClickListener(this);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_1) {
            Intent intent = new Intent(this,NoDiffUtilRecyclerViewActivity.class);
            startActivity(intent);

        } else if (id == R.id.tv_2) {
            Intent intent = new Intent(this,DiffUtilRecyclerViewActivity.class);
            startActivity(intent);


        }
    }
}
