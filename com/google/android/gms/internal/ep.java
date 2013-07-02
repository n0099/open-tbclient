package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.eq;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class ep implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eq.g gVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = gVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, gVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, gVar.f(), true);
        }
        if (d.contains(3)) {
            ad.a(parcel, 3, gVar.h(), true);
        }
        if (d.contains(4)) {
            ad.a(parcel, 4, gVar.i(), true);
        }
        if (d.contains(5)) {
            ad.a(parcel, 5, gVar.j(), true);
        }
        if (d.contains(6)) {
            ad.a(parcel, 6, gVar.k(), true);
        }
        if (d.contains(7)) {
            ad.a(parcel, 7, gVar.l());
        }
        if (d.contains(8)) {
            ad.a(parcel, 8, gVar.m(), true);
        }
        if (d.contains(9)) {
            ad.a(parcel, 9, gVar.n(), true);
        }
        if (d.contains(10)) {
            ad.a(parcel, 10, gVar.o());
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.g createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i2 = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    str7 = ac.l(parcel, a);
                    hashSet.add(2);
                    break;
                case 3:
                    str6 = ac.l(parcel, a);
                    hashSet.add(3);
                    break;
                case 4:
                    str5 = ac.l(parcel, a);
                    hashSet.add(4);
                    break;
                case 5:
                    str4 = ac.l(parcel, a);
                    hashSet.add(5);
                    break;
                case 6:
                    str3 = ac.l(parcel, a);
                    hashSet.add(6);
                    break;
                case 7:
                    z = ac.c(parcel, a);
                    hashSet.add(7);
                    break;
                case 8:
                    str2 = ac.l(parcel, a);
                    hashSet.add(8);
                    break;
                case 9:
                    str = ac.l(parcel, a);
                    hashSet.add(9);
                    break;
                case 10:
                    i = ac.f(parcel, a);
                    hashSet.add(10);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new eq.g(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.g[] newArray(int i) {
        return new eq.g[i];
    }
}
