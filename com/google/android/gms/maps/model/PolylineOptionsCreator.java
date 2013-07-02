package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PolylineOptionsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, polylineOptions.a());
        ad.b(parcel, 2, polylineOptions.b(), false);
        ad.a(parcel, 3, polylineOptions.c());
        ad.a(parcel, 4, polylineOptions.d());
        ad.a(parcel, 5, polylineOptions.e());
        ad.a(parcel, 6, polylineOptions.f());
        ad.a(parcel, 7, polylineOptions.g());
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = ac.b(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i2 = ac.f(parcel, a);
                    break;
                case 2:
                    arrayList = ac.c(parcel, a, LatLng.a);
                    break;
                case 3:
                    f2 = ac.i(parcel, a);
                    break;
                case 4:
                    i = ac.f(parcel, a);
                    break;
                case 5:
                    f = ac.i(parcel, a);
                    break;
                case 6:
                    z2 = ac.c(parcel, a);
                    break;
                case 7:
                    z = ac.c(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
