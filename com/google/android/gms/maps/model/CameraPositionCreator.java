package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class CameraPositionCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, cameraPosition.a());
        ad.a(parcel, 2, (Parcelable) cameraPosition.b, i, false);
        ad.a(parcel, 3, cameraPosition.c);
        ad.a(parcel, 4, cameraPosition.d);
        ad.a(parcel, 5, cameraPosition.e);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int b = ac.b(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 3:
                    f3 = ac.i(parcel, a);
                    break;
                case 4:
                    f2 = ac.i(parcel, a);
                    break;
                case 5:
                    f = ac.i(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new CameraPosition(i, latLng, f3, f2, f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
