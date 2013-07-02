package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;
/* loaded from: classes.dex */
public class dg {
    public static void a(Tile tile, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, tile.a());
        ad.a(parcel, 2, tile.b);
        ad.a(parcel, 3, tile.c);
        ad.a(parcel, 4, tile.d, false);
        ad.a(parcel, a);
    }
}
