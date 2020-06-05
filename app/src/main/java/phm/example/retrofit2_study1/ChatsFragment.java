package phm.example.retrofit2_study1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatsFragment extends Fragment {

    private RecyclerView recyclerView;
    private DataAdapter adapter;

    private ArrayList<Card> data;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chats_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        setRetrofit();

        return view;
    }

    void setRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us.api.blizzard.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Map map = new HashMap();
        map.put("locale","en_US");
        map.put("minionType","dragon"); // 용가리
        map.put("access_token","USLpnWB9KPyrMoLO6NvkAxEr1xtHFOImHD");

        RetrofitService request = retrofit.create(RetrofitService.class);
        Call<RetrofitRepo> call = request.getJSON(map);
        call.enqueue(new Callback<RetrofitRepo>() {
            @Override
            public void onResponse(Call<RetrofitRepo> call, Response<RetrofitRepo> response) {
                RetrofitRepo jsonResponse = response.body();
                data = new ArrayList<>();

                for(int i = 0; i<jsonResponse.getCards().size(); i++){

                    data.add(i,jsonResponse.getCards().get(i));
                }
                adapter = new DataAdapter(getContext(),data);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<RetrofitRepo> call, Throwable t) {
                Log.d("에러",t.getMessage());
            }

        });

    }


}
