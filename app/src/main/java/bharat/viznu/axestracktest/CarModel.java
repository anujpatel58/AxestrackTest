package bharat.viznu.axestracktest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maa on 20-09-2016.
 */
public class CarModel implements Parcelable {
    public static final Creator<CarModel> CREATOR = new Creator<CarModel>() {
        @Override
        public CarModel createFromParcel(Parcel in) {
            return new CarModel(in);
        }

        @Override
        public CarModel[] newArray(int size) {
            return new CarModel[size];
        }
    };
    private String carName;
    private String carImageURL;
    private String carPrice;
    private String carType;
    private String carKM;
    private String carYear;

    public CarModel(String carName, String carImageURL, String carPrice, String carType, String carKM, String carYear) {
        this.carName = carName;
        this.carImageURL = carImageURL;
        this.carPrice = carPrice;
        this.carType = carType;
        this.carKM = carKM;
        this.carYear = carYear;
    }

    protected CarModel(Parcel in) {
        carName = in.readString();
        carImageURL = in.readString();
        carPrice = in.readString();
        carType = in.readString();
        carKM = in.readString();
        carYear = in.readString();
    }

    public String getCarName() {
        return carName;
    }

    public String getCarImageURL() {
        return carImageURL;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public String getCarType() {
        return carType;
    }

    public String getCarKM() {
        return carKM;
    }

    public String getCarYear() {
        return carYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(carName);
        parcel.writeString(carImageURL);
        parcel.writeString(carPrice);
        parcel.writeString(carType);
        parcel.writeString(carKM);
        parcel.writeString(carYear);
    }
}
