package com.example.retrofitandroidexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitandroidexample.adapter.CountryAdapter;
import com.example.retrofitandroidexample.model.Diskon;
import com.example.retrofitandroidexample.model.Diskon;
import com.example.retrofitandroidexample.retrofit.GetDataServices;
import com.example.retrofitandroidexample.retrofit.RetrofitClientinstance;

import java.util.List;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private  ProgressDialog progressDialog;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

        GetDataServices services = RetrofitClientinstance.getRetrofit().create(GetDataServices.class);
        Call<List<Diskon>> call = services.getDiskon();

        call.enqueue(new Callback<List<Diskon>>() {
            @Override
            public void onResponse(Call<List<Diskon>> call, Response<List<Diskon>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Diskon>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "" + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("error", t.toString());

            }
        });

            }
    private void generateDataList(List<Diskon> body) {
        recyclerView = findViewById(R.id.custome_rec_view);
        adapter = new CountryAdapter(body, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

};

