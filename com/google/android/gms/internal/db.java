package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLngBounds;
/* loaded from: classes.dex */
public class db {
    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, latLngBounds.a());
        ad.a(parcel, 2, (Parcelable) latLngBounds.b, i, false);
        ad.a(parcel, 3, (Parcelable) latLngBounds.c, i, false);
        ad.a(parcel, a);
    }
}
