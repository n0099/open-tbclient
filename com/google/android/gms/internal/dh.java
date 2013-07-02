package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.TileOverlayOptions;
/* loaded from: classes.dex */
public class dh {
    public static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, tileOverlayOptions.a());
        ad.a(parcel, 2, tileOverlayOptions.b(), false);
        ad.a(parcel, 3, tileOverlayOptions.d());
        ad.a(parcel, 4, tileOverlayOptions.c());
        ad.a(parcel, a);
    }
}
