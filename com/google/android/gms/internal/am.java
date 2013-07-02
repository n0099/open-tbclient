package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ak;
/* loaded from: classes.dex */
public class am implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ak.a aVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, aVar.b);
        ad.a(parcel, 2, aVar.c, false);
        ad.a(parcel, 3, aVar.d);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ak.a createFromParcel(Parcel parcel) {
        int i = 0;
        int b = ac.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i2 = ac.f(parcel, a);
                    break;
                case 2:
                    str = ac.l(parcel, a);
                    break;
                case 3:
                    i = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new ak.a(i2, str, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ak.a[] newArray(int i) {
        return new ak.a[i];
    }
}
