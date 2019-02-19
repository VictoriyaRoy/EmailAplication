package com.example.user.emailaplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements EmailAdapter.EmailItemClicked {

    private List<EmailItem> list = generateEmailList();
    private String autor = "";
    private String subject = "", content = "", date = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        RecyclerView emailRecycler = findViewById(R.id.email_recycler_view);
        emailRecycler.setLayoutManager(new LinearLayoutManager(this));
        EmailAdapter emailAdapter = new EmailAdapter(list, this);
        emailRecycler.setAdapter(emailAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(MainActivity.this, NewMessage.class));
                startActivity(intent);
            }
        });
    }


    @Override
    public void itemClickedCallback(int itemPosition) {
        autor = list.get(itemPosition).getAutor();
        if (autor == null || autor.isEmpty()) {
            autor = "Anonymous";
        }
        subject = list.get(itemPosition).getSubject();
        if (subject == null || subject.isEmpty()) {
            subject = "No Subject";
        }
        content = list.get(itemPosition).getContent();
        if (content == null || content.isEmpty()) {
            content = "Empty Message";
        }
        date = list.get(itemPosition).getDate();


    Intent intent = new Intent(new Intent(MainActivity.this, DetailedActivity.class));
        intent.putExtra("Autor",autor);
        intent.putExtra("Subject",subject);
        intent.putExtra("Content",content);
        intent.putExtra("Date",date);

    startActivity(intent);

}

    private List<EmailItem> generateEmailList() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("Dylan", "Dylan`s Birthday", "Hello, my friend! I wanna invite you on my birthday on Friday 5 pm. Will you come?","2m ago"));
        list.add(new EmailItem("Tyler Joseph", "Concert of Twenty One Pilots", "Hey, I know you`re a fan of my group. I will give you 2 free concert tickets. Have a nice day!", "4h ago"));
        list.add(new EmailItem("Nick R.", "", "Hey, what`s up?","18 Feb"));
        list.add(new EmailItem("Alex", "Work", "","16 Feb"));
        return list;
    }
}