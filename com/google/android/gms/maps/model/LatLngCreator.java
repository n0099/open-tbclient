package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class LatLngCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LatLng latLng, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, latLng.a());
        ad.a(parcel, 2, latLng.b);
        ad.a(parcel, 3, latLng.c);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int b = ac.b(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    d2 = ac.j(parcel, a);
                    break;
                case 3:
                    d = ac.j(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new LatLng(i, d2, d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
