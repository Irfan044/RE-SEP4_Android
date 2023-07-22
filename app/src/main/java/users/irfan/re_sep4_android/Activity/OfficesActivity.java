package users.irfan.re_sep4_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import users.irfan.re_sep4_android.Adapters.OfficeListAdapter;
import users.irfan.re_sep4_android.Model.OfficeModel;
import users.irfan.re_sep4_android.R;
import users.irfan.re_sep4_android.ViewModel.OfficeListViewModel;

public class OfficesActivity extends AppCompatActivity implements OfficeListAdapter.ItemClickListener {

    private List<OfficeModel> officeModelList;
    private OfficeListAdapter adapter;
    private OfficeListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_offices);

        RecyclerView recyclerViewOffices = findViewById(R.id.recyclerViewOffices);
        final TextView noResult = findViewById(R.id.noResultTv);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerViewOffices.setLayoutManager(layoutManager);
        adapter = new OfficeListAdapter(this, officeModelList, this);
        recyclerViewOffices.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(OfficeListViewModel.class);
        viewModel.getOfficesListObserver().observe(this, new Observer<List<OfficeModel>>() {
            @Override
            public void onChanged(List<OfficeModel> officeModels) {
                if(officeModels != null){
                    officeModelList = officeModels;
                    adapter.setOfficeList(officeModels);
                    noResult.setVisibility(View.GONE);
                    Log.d("OfficesActivity", "This is line was executed");
                }else{
                    noResult.setVisibility(View.VISIBLE);
                    Log.d("OfficesActivity", "This is why 'NO RESULT FOUND' is printed");
                }
            }
        });
        viewModel.makeApiCall();
    }

    @Override
    public void onOfficeClick(OfficeModel office) {
        Toast.makeText(this, "Selected Office Name is: " +office.getName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Temperature of selected office is: " +office.getTemperature(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Temperature of selected office is: " +office.getRH(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Temperature of selected office is: " +office.getCO2(), Toast.LENGTH_SHORT).show();
    }
}