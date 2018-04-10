package depromeet.dongjune.com.movierecommand.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import depromeet.dongjune.com.movierecommand.R;
import depromeet.dongjune.com.movierecommand.model.MovieDataService;
import depromeet.dongjune.com.movierecommand.model.MovieInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieDataService movieDataService = (MovieDataService) MovieDataService.retrofit.create(MovieInfo.class);
        Call<List<MovieInfo>> call = movieDataService.getMovieData("", "");
        call.enqueue(new Callback<List<MovieInfo>>() {
            @Override
            public void onResponse(Call<List<MovieInfo>> call,
                                   Response<List<MovieInfo>> response) {

                Log.d("responseBody", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<MovieInfo>> call, Throwable t) {

            }
        });


    }


}
