package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.eq;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class ek implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eq.b.a aVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = aVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, aVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, aVar.f());
        }
        if (d.contains(3)) {
            ad.a(parcel, 3, aVar.h());
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.b.a createFromParcel(Parcel parcel) {
        int i = 0;
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i3 = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    i2 = ac.f(parcel, a);
                    hashSet.add(2);
                    break;
                case 3:
                    i = ac.f(parcel, a);
                    hashSet.add(3);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new eq.b.a(hashSet, i3, i2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.b.a[] newArray(int i) {
        return new eq.b.a[i];
    }
}
