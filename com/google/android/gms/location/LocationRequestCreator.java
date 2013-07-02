package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.LocationClientOption;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class LocationRequestCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LocationRequest locationRequest, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, locationRequest.b);
        ad.a(parcel, (int) LocationClientOption.MIN_SCAN_SPAN, locationRequest.a);
        ad.a(parcel, 2, locationRequest.c);
        ad.a(parcel, 3, locationRequest.d);
        ad.a(parcel, 4, locationRequest.e);
        ad.a(parcel, 5, locationRequest.f);
        ad.a(parcel, 6, locationRequest.g);
        ad.a(parcel, 7, locationRequest.h);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LocationRequest createFromParcel(Parcel parcel) {
        LocationRequest locationRequest = new LocationRequest();
        int b = ac.b(parcel);
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    locationRequest.b = ac.f(parcel, a);
                    break;
                case 2:
                    locationRequest.c = ac.g(parcel, a);
                    break;
                case 3:
                    locationRequest.d = ac.g(parcel, a);
                    break;
                case 4:
                    locationRequest.e = ac.c(parcel, a);
                    break;
                case 5:
                    locationRequest.f = ac.g(parcel, a);
                    break;
                case 6:
                    locationRequest.g = ac.f(parcel, a);
                    break;
                case 7:
                    locationRequest.h = ac.i(parcel, a);
                    break;
                case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                    locationRequest.a = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return locationRequest;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
