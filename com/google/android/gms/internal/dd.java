package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.MarkerOptions;
/* loaded from: classes.dex */
public class dd {
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
}
