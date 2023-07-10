package users.irfan.re_sep4_android.DataSource;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static String BASE_URL = "https://localhost:44325/api/Offices/";

    public static Retrofit retrofit;

    public static Retrofit getRetroClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
