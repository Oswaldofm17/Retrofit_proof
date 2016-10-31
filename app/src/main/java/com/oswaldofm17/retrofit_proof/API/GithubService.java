package com.oswaldofm17.retrofit_proof.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by oswaldofm on 10/31/16.
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(
            @Path("user") String user);
}
