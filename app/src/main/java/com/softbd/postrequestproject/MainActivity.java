package com.softbd.postrequestproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private RecyclerView recyclerView;
    private RowDataAdapter adapter;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mmcm.gov.bd/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        setPostData();
    }

    public void setPostData() {
        Call<ServerData> call = jsonPlaceHolderApi.createPost(141826, 10, 7, 51);
        call.enqueue(new Callback<ServerData>() {


            @Override
            public void onResponse(Call<ServerData> call, Response<ServerData> response) {
                if (response.isSuccessful()) {
                    ServerData serverData = response.body();
                    if (serverData.getStatus() == 1) {

                        List<ServerData.Result> result = serverData.getResult();
                        adapter = new RowDataAdapter(result, mContext);
                        recyclerView.setAdapter(adapter);

                    } else {
                        Toast.makeText(MainActivity.this, "Status 0", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ServerData> call, Throwable t) {

            }
        });


    }
}
