package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.PolylineOptions;
/* loaded from: classes.dex */
public class df {
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
}
