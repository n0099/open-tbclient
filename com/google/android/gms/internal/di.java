package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.VisibleRegion;
/* loaded from: classes.dex */
public class di {
    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, visibleRegion.a());
        ad.a(parcel, 2, (Parcelable) visibleRegion.b, i, false);
        ad.a(parcel, 3, (Parcelable) visibleRegion.c, i, false);
        ad.a(parcel, 4, (Parcelable) visibleRegion.d, i, false);
        ad.a(parcel, 5, (Parcelable) visibleRegion.e, i, false);
        ad.a(parcel, 6, (Parcelable) visibleRegion.f, i, false);
        ad.a(parcel, a);
    }
}
