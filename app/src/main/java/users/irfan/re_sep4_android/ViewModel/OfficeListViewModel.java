package users.irfan.re_sep4_android.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import users.irfan.re_sep4_android.DataSource.APIService;
import users.irfan.re_sep4_android.DataSource.ServiceGenerator;
import users.irfan.re_sep4_android.Model.OfficeModel;

public class OfficeListViewModel extends ViewModel {

        private MutableLiveData<List<OfficeModel>> officesList;

        public OfficeListViewModel(){
                officesList = new MutableLiveData<>();
        }

        public MutableLiveData<List<OfficeModel>> getOfficesListObserver(){
                return officesList;

        }

        public void makeApiCall(){
                APIService apiService = ServiceGenerator.getRetroClient().create(APIService.class);
                Call<List<OfficeModel>> call = apiService.getOfficeList();
                call.enqueue(new Callback<List<OfficeModel>>() {
                        @Override
                        public void onResponse(Call<List<OfficeModel>> call, Response<List<OfficeModel>> response) {
                                officesList.postValue(response.body());
                        }

                        @Override
                        public void onFailure(Call<List<OfficeModel>> call, Throwable t) {
                                officesList.postValue((null));
                        }
                });
        }
}
