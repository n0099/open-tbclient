package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class TileOverlayOptionsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, tileOverlayOptions.a());
        ad.a(parcel, 2, tileOverlayOptions.b(), false);
        ad.a(parcel, 3, tileOverlayOptions.d());
        ad.a(parcel, 4, tileOverlayOptions.c());
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = ac.b(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        int i = 0;
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
                    z = ac.c(parcel, a);
                    break;
                case 4:
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
        return new TileOverlayOptions(i, iBinder, z, f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
