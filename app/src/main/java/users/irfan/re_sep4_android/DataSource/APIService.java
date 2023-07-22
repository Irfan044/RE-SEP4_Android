package users.irfan.re_sep4_android.DataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import users.irfan.re_sep4_android.Model.OfficeModel;

public interface APIService {

    @GET("api/Offices/GetAllOffices")
    Call<List<OfficeModel>> getOfficeList();

}
