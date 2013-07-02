package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class LatLngBoundsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, latLngBounds.a());
        ad.a(parcel, 2, (Parcelable) latLngBounds.b, i, false);
        ad.a(parcel, 3, (Parcelable) latLngBounds.c, i, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i;
        LatLng latLng3 = null;
        int b = ac.b(parcel);
        int i2 = 0;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    LatLng latLng5 = latLng3;
                    latLng2 = latLng4;
                    i = ac.f(parcel, a);
                    latLng = latLng5;
                    break;
                case 2:
                    LatLng latLng6 = (LatLng) ac.a(parcel, a, LatLng.a);
                    i = i2;
                    latLng = latLng3;
                    latLng2 = latLng6;
                    break;
                case 3:
                    latLng = (LatLng) ac.a(parcel, a, LatLng.a);
                    latLng2 = latLng4;
                    i = i2;
                    break;
                default:
                    ac.b(parcel, a);
                    latLng = latLng3;
                    latLng2 = latLng4;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng4 = latLng2;
            latLng3 = latLng;
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new LatLngBounds(i2, latLng4, latLng3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
