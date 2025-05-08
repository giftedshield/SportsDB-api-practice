    package com.example.a10pplg2_api;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.ProgressBar;
    import android.widget.Toast;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.google.gson.Gson;

    import java.util.ArrayList;
    import java.util.List;

    import retrofit2.Callback;
    import retrofit2.Call;
    import retrofit2.Response;
    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;
    import retrofit2.http.GET;
    import retrofit2.http.Query;

    public class MainActivity extends AppCompatActivity {
        private ProgressBar pbProgress;
        private RecyclerView recyclerView;
        private mahoraga adapter;
        private List<Team> teamList = new ArrayList<>();
        private ApiService apiService;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.mainRecyclerView);
            pbProgress = findViewById(R.id.pbProgress);

            adapter = new mahoraga(teamList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.thesportsdb.com/api/v1/json/") // base urlnya jgn salah
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(ApiService.class);


            fetchTeams();
        }

        private void fetchTeams() {
            apiService.getUsers("English Premier League").enqueue(new Callback<TeamsResponse>() {
                @Override
                public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Log.d("API_SUCCESS", "Data: " + new Gson().toJson(response.body()));


                        teamList.clear();
                        teamList.addAll(response.body().getTeams());
                        adapter.notifyDataSetChanged();
                        recyclerView.setVisibility(View.VISIBLE);
                        pbProgress.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<TeamsResponse> call, Throwable t) {
                    Log.e("API_FAILURE", "Error: " + t.getMessage(), t);
                }
            });
        }
    }

