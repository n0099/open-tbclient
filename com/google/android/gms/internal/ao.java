package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.an;
/* loaded from: classes.dex */
public class ao implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(an.a aVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, aVar.a());
        ad.a(parcel, 2, aVar.b());
        ad.a(parcel, 3, aVar.c());
        ad.a(parcel, 4, aVar.d());
        ad.a(parcel, 5, aVar.e());
        ad.a(parcel, 6, aVar.f(), false);
        ad.a(parcel, 7, aVar.g());
        ad.a(parcel, 8, aVar.i(), false);
        ad.a(parcel, 9, (Parcelable) aVar.k(), i, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public an.a createFromParcel(Parcel parcel) {
        ai aiVar = null;
        int i = 0;
        int b = ac.b(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i4 = ac.f(parcel, a);
                    break;
                case 2:
                    i3 = ac.f(parcel, a);
                    break;
                case 3:
                    z2 = ac.c(parcel, a);
                    break;
                case 4:
                    i2 = ac.f(parcel, a);
                    break;
                case 5:
                    z = ac.c(parcel, a);
                    break;
                case 6:
                    str2 = ac.l(parcel, a);
                    break;
                case 7:
                    i = ac.f(parcel, a);
                    break;
                case 8:
                    str = ac.l(parcel, a);
                    break;
                case 9:
                    aiVar = (ai) ac.a(parcel, a, ai.a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new an.a(i4, i3, z2, i2, z, str2, i, str, aiVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public an.a[] newArray(int i) {
        return new an.a[i];
    }
}
