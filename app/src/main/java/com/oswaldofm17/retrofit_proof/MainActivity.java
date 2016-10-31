package com.oswaldofm17.retrofit_proof;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.oswaldofm17.retrofit_proof.API.GithubClient;
import com.oswaldofm17.retrofit_proof.API.GithubService;
import com.oswaldofm17.retrofit_proof.API.Repository;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.txtResult)
    TextView txtResult;

    GithubClient githubClient = new GithubClient();
    GithubService githubService;
    @Bind(R.id.buttonFetch)
    Button buttonFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonFetch)
    public void handleFetchClick() {
        Call<List<Repository>> call = githubService.listRepos("Oswaldofm17");
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                txtResult.setText(response.body().size());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                txtResult.setText("Something went wrong: " + t.getMessage());
            }
        });
    }
}
