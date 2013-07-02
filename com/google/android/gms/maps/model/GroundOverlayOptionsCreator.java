package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class GroundOverlayOptionsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int b = ac.b(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    iBinder = ac.m(parcel, a);
                    break;
                case 3:
                    latLng = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 4:
                    f = ac.i(parcel, a);
                    break;
                case 5:
                    f2 = ac.i(parcel, a);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) ac.a(parcel, a, LatLngBounds.a);
                    break;
                case 7:
                    f3 = ac.i(parcel, a);
                    break;
                case 8:
                    f4 = ac.i(parcel, a);
                    break;
                case 9:
                    z = ac.c(parcel, a);
                    break;
                case 10:
                    f5 = ac.i(parcel, a);
                    break;
                case 11:
                    f6 = ac.i(parcel, a);
                    break;
                case 12:
                    f7 = ac.i(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
