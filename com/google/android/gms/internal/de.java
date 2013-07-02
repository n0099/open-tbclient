package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.PolygonOptions;
/* loaded from: classes.dex */
public class de {
    public static void a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, polygonOptions.a());
        ad.b(parcel, 2, polygonOptions.c(), false);
        ad.c(parcel, 3, polygonOptions.b(), false);
        ad.a(parcel, 4, polygonOptions.d());
        ad.a(parcel, 5, polygonOptions.e());
        ad.a(parcel, 6, polygonOptions.f());
        ad.a(parcel, 7, polygonOptions.g());
        ad.a(parcel, 8, polygonOptions.h());
        ad.a(parcel, 9, polygonOptions.i());
        ad.a(parcel, a);
    }
}
