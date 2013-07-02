package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
import com.google.android.gms.maps.model.CameraPosition;
/* loaded from: classes.dex */
public class GoogleMapOptionsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, googleMapOptions.a());
        ad.a(parcel, 2, googleMapOptions.b());
        ad.a(parcel, 3, googleMapOptions.c());
        ad.a(parcel, 4, googleMapOptions.j());
        ad.a(parcel, 5, (Parcelable) googleMapOptions.k(), i, false);
        ad.a(parcel, 6, googleMapOptions.d());
        ad.a(parcel, 7, googleMapOptions.e());
        ad.a(parcel, 8, googleMapOptions.f());
        ad.a(parcel, 9, googleMapOptions.g());
        ad.a(parcel, 10, googleMapOptions.h());
        ad.a(parcel, 11, googleMapOptions.i());
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = 0;
        int b2 = ac.b(parcel);
        CameraPosition cameraPosition = null;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        byte b7 = 0;
        int i = 0;
        byte b8 = 0;
        byte b9 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i2 = ac.f(parcel, a);
                    break;
                case 2:
                    b9 = ac.d(parcel, a);
                    break;
                case 3:
                    b8 = ac.d(parcel, a);
                    break;
                case 4:
                    i = ac.f(parcel, a);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) ac.a(parcel, a, CameraPosition.a);
                    break;
                case 6:
                    b7 = ac.d(parcel, a);
                    break;
                case 7:
                    b6 = ac.d(parcel, a);
                    break;
                case 8:
                    b5 = ac.d(parcel, a);
                    break;
                case 9:
                    b4 = ac.d(parcel, a);
                    break;
                case 10:
                    b3 = ac.d(parcel, a);
                    break;
                case 11:
                    b = ac.d(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b2) {
            throw new ac.a("Overread allowed size end=" + b2, parcel);
        }
        return new GoogleMapOptions(i2, b9, b8, i, cameraPosition, b7, b6, b5, b4, b3, b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
