package users.irfan.re_sep4_android.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import users.irfan.re_sep4_android.Model.OfficeModel;
import users.irfan.re_sep4_android.R;

public class OfficeListAdapter extends RecyclerView.Adapter<OfficeListAdapter.MyViewHolder> {
    private Context context;
    private List<OfficeModel> officeList;
    private ItemClickListener clickListener;

    public OfficeListAdapter(Context context, List<OfficeModel> officeList, ItemClickListener clickListener){
        this.context = context;
        this.officeList = officeList;
        this.clickListener = clickListener;
    }

    public void setOfficeList(List<OfficeModel> officeList){
        this.officeList = officeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OfficeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfficeListAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvName.setText(this.officeList.get(position).getName().toString());
        holder.tvArea.setText(String.valueOf(this.officeList.get(position).getArea()));
        holder.tvDateTime.setText(this.officeList.get(position).getDateTime().toString());
        holder.tvTemp.setText(String.valueOf(this.officeList.get(position).getTemperature()));
        holder.tvHumidity.setText(String.valueOf(this.officeList.get(position).getRH()));
        holder.tvCO2.setText(String.valueOf(this.officeList.get(position).getCO2()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onOfficeClick(officeList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.officeList != null){
            return this.officeList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvArea, tvDateTime, tvTemp, tvHumidity, tvCO2;

        public MyViewHolder(View itemView){
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.nameView);
            tvArea = (TextView)itemView.findViewById(R.id.areaView);
            tvDateTime = (TextView)itemView.findViewById(R.id.dateTimeView);
            tvTemp = (TextView)itemView.findViewById(R.id.tempView);
            tvHumidity = (TextView)itemView.findViewById(R.id.humidityView);
            tvCO2 = (TextView)itemView.findViewById(R.id.co2View);
        }
    }

    public interface ItemClickListener{
        public void onOfficeClick(OfficeModel office);
    }
}
