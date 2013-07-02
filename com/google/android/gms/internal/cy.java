package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.CameraPosition;
/* loaded from: classes.dex */
public class cy {
    public static void a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, cameraPosition.a());
        ad.a(parcel, 2, (Parcelable) cameraPosition.b, i, false);
        ad.a(parcel, 3, cameraPosition.c);
        ad.a(parcel, 4, cameraPosition.d);
        ad.a(parcel, 5, cameraPosition.e);
        ad.a(parcel, a);
    }
}
