package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class MarkerOptionsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, markerOptions.a());
        ad.a(parcel, 2, (Parcelable) markerOptions.c(), i, false);
        ad.a(parcel, 3, markerOptions.d(), false);
        ad.a(parcel, 4, markerOptions.e(), false);
        ad.a(parcel, 5, markerOptions.b(), false);
        ad.a(parcel, 6, markerOptions.f());
        ad.a(parcel, 7, markerOptions.g());
        ad.a(parcel, 8, markerOptions.h());
        ad.a(parcel, 9, markerOptions.i());
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MarkerOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        IBinder iBinder = null;
        int b = ac.b(parcel);
        boolean z2 = false;
        float f2 = 0.0f;
        String str = null;
        String str2 = null;
        LatLng latLng = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 3:
                    str2 = ac.l(parcel, a);
                    break;
                case 4:
                    str = ac.l(parcel, a);
                    break;
                case 5:
                    iBinder = ac.m(parcel, a);
                    break;
                case 6:
                    f2 = ac.i(parcel, a);
                    break;
                case 7:
                    f = ac.i(parcel, a);
                    break;
                case 8:
                    z2 = ac.c(parcel, a);
                    break;
                case 9:
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
        return new MarkerOptions(i, latLng, str2, str, iBinder, f2, f, z2, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
