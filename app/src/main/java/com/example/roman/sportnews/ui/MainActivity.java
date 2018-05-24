package com.example.roman.sportnews.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.roman.sportnews.R;
import com.example.roman.sportnews.network.requests.RetrofitService;
import com.example.roman.sportnews.network.requests.models.Event;
import com.example.roman.sportnews.network.requests.models.ListEvents;
import com.example.roman.sportnews.network.requests.services.ApiRequests;
import com.example.roman.sportnews.view.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String[] data = {"football", "hockey", "tennis", "basketball", "volleyball","cybersport"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Map<String,String> stringMap=new HashMap<>();
                stringMap.put("category",data[position]);
                RetrofitService.createService(ApiRequests.class).eventList(stringMap).enqueue(new Callback<ListEvents>() {
                    @Override
                    public void onResponse(Call<ListEvents> call, Response<ListEvents> response) {
                        if(response.isSuccessful()){
                            initRecyclerView(response.body().getEvents());
                        }
                    }

                    @Override
                    public void onFailure(Call<ListEvents> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void initRecyclerView(ArrayList<Event> events){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, events);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
