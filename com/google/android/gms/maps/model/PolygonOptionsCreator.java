package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PolygonOptionsCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = ac.b(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
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
                    arrayList = ac.c(parcel, a, LatLng.a);
                    break;
                case 3:
                    ac.a(parcel, a, arrayList2, getClass().getClassLoader());
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
                    z2 = ac.c(parcel, a);
                    break;
                case 9:
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
        return new PolygonOptions(i3, arrayList, arrayList2, f2, i2, i, f, z2, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
