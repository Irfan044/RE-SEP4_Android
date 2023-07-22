package users.irfan.re_sep4_android.DataSource;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static APIService apiService;

    public static APIService getApiService() {
        if (apiService == null) {
            apiService = new Retrofit.Builder()
                    .baseUrl("https://localhost:44325/")
                    /*https://localhost:44325/ needs to be changed to value of "Remote URL" from Conveyor by Keyoti
                    extension for Visual Studio 2022 in order for the API connection to work.*/
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(APIService.class);
        }
        return apiService;
    }
}
