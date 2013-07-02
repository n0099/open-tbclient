package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes.dex */
public class dc {
    public static void a(LatLng latLng, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, latLng.a());
        ad.a(parcel, 2, latLng.b);
        ad.a(parcel, 3, latLng.c);
        ad.a(parcel, a);
    }
}
