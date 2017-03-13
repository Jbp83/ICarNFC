package com.example.jb.icarnfc;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService1 service = retrofit.create(GitHubService1.class);
        Call<List<Repo>> repos = service.listRepos("machadacosta");

        repos.enqueue(new SortedList.Callback<List<Repo>>() {
            @Override
            public void onResponse(Response<List<Repo>> response, Retrofit retrofit) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                List<Repo> allRepos = response.body();
            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), String.format("KO"), Toast.LENGTH_SHORT).show(); }
        });

    }




}
