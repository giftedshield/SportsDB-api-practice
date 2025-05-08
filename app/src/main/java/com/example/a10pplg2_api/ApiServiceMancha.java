package com.example.a10pplg2_api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceMancha {
    @GET("/api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain")//bukan base urlnya ingettttttt
    Call<TeamsResponse> getUsers(@Query("league") String league);
}

