package bharat.viznu.axestracktest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarListAdapter extends BaseAdapter {
    private static final int MIN_DISK_CACHE_SIZE = 32 * 1024 * 1024;       // 32MB
    private static final int MAX_DISK_CACHE_SIZE = 512 * 1024 * 1024;      // 512MB
    private List<CarModel> cars;
    private Activity mActivity;
    private LayoutInflater inflater;

    public CarListAdapter(List<CarModel> cars, Activity mActivity) {
        this.cars = cars;
        this.mActivity = mActivity;
        inflater = LayoutInflater.from(this.mActivity);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_cars, parent, false);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        final CarModel car = cars.get(position);
        holder.carName.setText(car.getCarName());
        holder.carPrice.setText("\u20b9 " + car.getCarPrice());
        holder.carYear.setText(car.getCarYear());
        holder.carKM.setText(car.getCarKM());
        holder.carType.setText(car.getCarType());
        Picasso mBuilder = new Picasso.Builder(mActivity).indicatorsEnabled(true).downloader(new OkHttpDownloader(mActivity, MAX_DISK_CACHE_SIZE)).build();
        mBuilder.load(car.getCarImageURL()).error(R.mipmap.ic_launcher).into(holder.carImage);
        return convertView;
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder {
        public TextView carName, carPrice, carYear, carKM, carType;
        public ImageView carImage;

        public MyViewHolder(View view) {
            carName = (TextView) view.findViewById(R.id.car_name_tv);
            carPrice = (TextView) view.findViewById(R.id.car_price_tv);
            carYear = (TextView) view.findViewById(R.id.year_tv);
            carKM = (TextView) view.findViewById(R.id.km_tv);
            carImage = (ImageView) view.findViewById(R.id.car_iv);
            carType = (TextView) view.findViewById(R.id.type_tv);
        }
    }
}
