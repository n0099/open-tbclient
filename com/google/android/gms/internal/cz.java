package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.CircleOptions;
/* loaded from: classes.dex */
public class cz {
    public static void a(CircleOptions circleOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, circleOptions.a());
        ad.a(parcel, 2, (Parcelable) circleOptions.b(), i, false);
        ad.a(parcel, 3, circleOptions.c());
        ad.a(parcel, 4, circleOptions.d());
        ad.a(parcel, 5, circleOptions.e());
        ad.a(parcel, 6, circleOptions.f());
        ad.a(parcel, 7, circleOptions.g());
        ad.a(parcel, 8, circleOptions.h());
        ad.a(parcel, a);
    }
}
