package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class CircleOptionsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = ac.b(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i3 = ac.f(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 3:
                    d = ac.j(parcel, a);
                    break;
                case 4:
                    f2 = ac.i(parcel, a);
                    break;
                case 5:
                    i2 = ac.f(parcel, a);
                    break;
                case 6:
                    i = ac.f(parcel, a);
                    break;
                case 7:
                    f = ac.i(parcel, a);
                    break;
                case 8:
                    z = ac.c(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
