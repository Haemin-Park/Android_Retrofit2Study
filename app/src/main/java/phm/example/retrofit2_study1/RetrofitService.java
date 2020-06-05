package phm.example.retrofit2_study1;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface RetrofitService {

    @GET("hearthstone/cards")
    Call<RetrofitRepo> getJSON(
            @QueryMap Map<String, String> option
    );

}
