package depromeet.dongjune.com.movierecommand.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dongjune on 2018-04-11.
 */

public interface MovieDataService {
    @GET("/movie")
    Call<List<MovieInfo>> getMovieData(
            @Path("query") String query, @Path("genre") String genre);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://13.124.130.138")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}


