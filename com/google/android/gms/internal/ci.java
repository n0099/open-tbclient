package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.GoogleMapOptions;
/* loaded from: classes.dex */
public class ci {
    public static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, googleMapOptions.a());
        ad.a(parcel, 2, googleMapOptions.b());
        ad.a(parcel, 3, googleMapOptions.c());
        ad.a(parcel, 4, googleMapOptions.j());
        ad.a(parcel, 5, (Parcelable) googleMapOptions.k(), i, false);
        ad.a(parcel, 6, googleMapOptions.d());
        ad.a(parcel, 7, googleMapOptions.e());
        ad.a(parcel, 8, googleMapOptions.f());
        ad.a(parcel, 9, googleMapOptions.g());
        ad.a(parcel, 10, googleMapOptions.h());
        ad.a(parcel, 11, googleMapOptions.i());
        ad.a(parcel, a);
    }
}
