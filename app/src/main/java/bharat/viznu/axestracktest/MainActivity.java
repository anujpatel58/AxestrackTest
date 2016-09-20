package bharat.viznu.axestracktest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView mListView;
    private List<CarModel> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.cars_lv);
        cars = new ArrayList<>();
        cars.add(new CarModel("Mahindra XUV-500", "https://images.cardekho.com/images/uploadimages/1457609708125/Picture-1.jpg", "14.2 Lakhs", "Petrol", "20000 km", "2014"));
        cars.add(new CarModel("Mahindra E20", "http://www.mahindracarsindia.com/wp-content/uploads/2012/12/mahindra-e20-front.jpg", "4.2 Lakhs", "Electric", "10000 km", "2013"));
        cars.add(new CarModel("Mahindra Reva", "http://www.mahindracarsindia.com/wp-content/uploads/2013/01/mahindra-reva-e2o1.jpg", "5.2 Lakhs", "Electric", "8000 km", "2015"));
        cars.add(new CarModel("Mahindra Verito", "http://www.mahindracarsindia.com/wp-content/uploads/2013/01/mahindra-verito-cs.jpg", "8.2 Lakhs", "Diesel", "4000 km", "2016"));
        mListView.setAdapter(new CarListAdapter(cars, MainActivity.this));
    }
}
