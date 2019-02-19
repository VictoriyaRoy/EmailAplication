package com.example.user.emailaplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedActivity extends AppCompatActivity {
    private TextView autorTv, subjectTv, contentTv, dateTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Bundle arguments = getIntent().getExtras();
        String autor = arguments.get("Autor").toString();
        autorTv = findViewById(R.id.autor_text_view);
        autorTv.setText(autor);
        String subject = arguments.get("Subject").toString();
        subjectTv = findViewById(R.id.subject_text_view);
        subjectTv.setText(subject);
        String content = arguments.get("Content").toString();
        contentTv = findViewById(R.id.content_text_view);
        contentTv.setText(content);
        String date = arguments.get("Date").toString();
        dateTv = findViewById(R.id.date_text_view);
        dateTv.setText(date);

    }
}
