package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.GroundOverlayOptions;
/* loaded from: classes.dex */
public class da {
    public static void a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, groundOverlayOptions.b());
        ad.a(parcel, 2, groundOverlayOptions.a(), false);
        ad.a(parcel, 3, (Parcelable) groundOverlayOptions.c(), i, false);
        ad.a(parcel, 4, groundOverlayOptions.d());
        ad.a(parcel, 5, groundOverlayOptions.e());
        ad.a(parcel, 6, (Parcelable) groundOverlayOptions.f(), i, false);
        ad.a(parcel, 7, groundOverlayOptions.g());
        ad.a(parcel, 8, groundOverlayOptions.h());
        ad.a(parcel, 9, groundOverlayOptions.l());
        ad.a(parcel, 10, groundOverlayOptions.i());
        ad.a(parcel, 11, groundOverlayOptions.j());
        ad.a(parcel, 12, groundOverlayOptions.k());
        ad.a(parcel, a);
    }
}
