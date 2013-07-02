package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.eq;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class ej implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eq.b bVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = bVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, bVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, (Parcelable) bVar.f(), i, true);
        }
        if (d.contains(3)) {
            ad.a(parcel, 3, (Parcelable) bVar.h(), i, true);
        }
        if (d.contains(4)) {
            ad.a(parcel, 4, bVar.i());
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.b createFromParcel(Parcel parcel) {
        eq.b.C0034b c0034b = null;
        int i = 0;
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        eq.b.a aVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i2 = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    aVar = (eq.b.a) ac.a(parcel, a, eq.b.a.a);
                    break;
                case 3:
                    hashSet.add(3);
                    c0034b = (eq.b.C0034b) ac.a(parcel, a, eq.b.C0034b.a);
                    break;
                case 4:
                    i = ac.f(parcel, a);
                    hashSet.add(4);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new eq.b(hashSet, i2, aVar, c0034b, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.b[] newArray(int i) {
        return new eq.b[i];
    }
}
