package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.eq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class er implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eq eqVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = eqVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, eqVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, eqVar.f(), true);
        }
        if (d.contains(3)) {
            ad.a(parcel, 3, (Parcelable) eqVar.h(), i, true);
        }
        if (d.contains(4)) {
            ad.a(parcel, 4, eqVar.i(), true);
        }
        if (d.contains(5)) {
            ad.a(parcel, 5, eqVar.j(), true);
        }
        if (d.contains(6)) {
            ad.a(parcel, 6, eqVar.k());
        }
        if (d.contains(7)) {
            ad.a(parcel, 7, (Parcelable) eqVar.l(), i, true);
        }
        if (d.contains(8)) {
            ad.a(parcel, 8, eqVar.m(), true);
        }
        if (d.contains(9)) {
            ad.a(parcel, 9, eqVar.n(), true);
        }
        if (d.contains(10)) {
            ad.b(parcel, 10, eqVar.o(), true);
        }
        if (d.contains(11)) {
            ad.a(parcel, 11, eqVar.p(), true);
        }
        if (d.contains(12)) {
            ad.a(parcel, 12, eqVar.q());
        }
        if (d.contains(13)) {
            ad.a(parcel, 13, eqVar.r());
        }
        if (d.contains(14)) {
            ad.a(parcel, 14, eqVar.s(), true);
        }
        if (d.contains(15)) {
            ad.a(parcel, 15, (Parcelable) eqVar.t(), i, true);
        }
        if (d.contains(16)) {
            ad.a(parcel, 16, eqVar.u());
        }
        if (d.contains(19)) {
            ad.a(parcel, 19, (Parcelable) eqVar.w(), i, true);
        }
        if (d.contains(18)) {
            ad.a(parcel, 18, eqVar.v(), true);
        }
        if (d.contains(21)) {
            ad.a(parcel, 21, eqVar.y());
        }
        if (d.contains(20)) {
            ad.a(parcel, 20, eqVar.x(), true);
        }
        if (d.contains(23)) {
            ad.b(parcel, 23, eqVar.A(), true);
        }
        if (d.contains(22)) {
            ad.b(parcel, 22, eqVar.z(), true);
        }
        if (d.contains(25)) {
            ad.a(parcel, 25, eqVar.C());
        }
        if (d.contains(24)) {
            ad.a(parcel, 24, eqVar.B());
        }
        if (d.contains(27)) {
            ad.a(parcel, 27, eqVar.E(), true);
        }
        if (d.contains(26)) {
            ad.a(parcel, 26, eqVar.D(), true);
        }
        if (d.contains(29)) {
            ad.a(parcel, 29, eqVar.G());
        }
        if (d.contains(28)) {
            ad.b(parcel, 28, eqVar.F(), true);
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq createFromParcel(Parcel parcel) {
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        eq.a aVar = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        eq.b bVar = null;
        String str4 = null;
        String str5 = null;
        ArrayList arrayList = null;
        String str6 = null;
        int i3 = 0;
        boolean z = false;
        String str7 = null;
        eq.d dVar = null;
        boolean z2 = false;
        String str8 = null;
        eq.e eVar = null;
        String str9 = null;
        int i4 = 0;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        int i5 = 0;
        int i6 = 0;
        String str10 = null;
        String str11 = null;
        ArrayList arrayList4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    str = ac.l(parcel, a);
                    hashSet.add(2);
                    break;
                case 3:
                    hashSet.add(3);
                    aVar = (eq.a) ac.a(parcel, a, eq.a.a);
                    break;
                case 4:
                    str2 = ac.l(parcel, a);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = ac.l(parcel, a);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = ac.f(parcel, a);
                    hashSet.add(6);
                    break;
                case 7:
                    hashSet.add(7);
                    bVar = (eq.b) ac.a(parcel, a, eq.b.a);
                    break;
                case 8:
                    str4 = ac.l(parcel, a);
                    hashSet.add(8);
                    break;
                case 9:
                    str5 = ac.l(parcel, a);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayList = ac.c(parcel, a, eq.c.a);
                    hashSet.add(10);
                    break;
                case 11:
                    str6 = ac.l(parcel, a);
                    hashSet.add(11);
                    break;
                case 12:
                    i3 = ac.f(parcel, a);
                    hashSet.add(12);
                    break;
                case 13:
                    z = ac.c(parcel, a);
                    hashSet.add(13);
                    break;
                case 14:
                    str7 = ac.l(parcel, a);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    dVar = (eq.d) ac.a(parcel, a, eq.d.a);
                    break;
                case 16:
                    z2 = ac.c(parcel, a);
                    hashSet.add(16);
                    break;
                case 17:
                default:
                    ac.b(parcel, a);
                    break;
                case 18:
                    str8 = ac.l(parcel, a);
                    hashSet.add(18);
                    break;
                case 19:
                    hashSet.add(19);
                    eVar = (eq.e) ac.a(parcel, a, eq.e.a);
                    break;
                case 20:
                    str9 = ac.l(parcel, a);
                    hashSet.add(20);
                    break;
                case 21:
                    i4 = ac.f(parcel, a);
                    hashSet.add(21);
                    break;
                case DERTags.IA5_STRING /* 22 */:
                    arrayList2 = ac.c(parcel, a, eq.g.a);
                    hashSet.add(22);
                    break;
                case DERTags.UTC_TIME /* 23 */:
                    arrayList3 = ac.c(parcel, a, eq.h.a);
                    hashSet.add(23);
                    break;
                case DERTags.GENERALIZED_TIME /* 24 */:
                    i5 = ac.f(parcel, a);
                    hashSet.add(24);
                    break;
                case DERTags.GRAPHIC_STRING /* 25 */:
                    i6 = ac.f(parcel, a);
                    hashSet.add(25);
                    break;
                case DERTags.VISIBLE_STRING /* 26 */:
                    str10 = ac.l(parcel, a);
                    hashSet.add(26);
                    break;
                case DERTags.GENERAL_STRING /* 27 */:
                    str11 = ac.l(parcel, a);
                    hashSet.add(27);
                    break;
                case DERTags.UNIVERSAL_STRING /* 28 */:
                    arrayList4 = ac.c(parcel, a, eq.i.a);
                    hashSet.add(28);
                    break;
                case 29:
                    z3 = ac.c(parcel, a);
                    hashSet.add(29);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new eq(hashSet, i, str, aVar, str2, str3, i2, bVar, str4, str5, arrayList, str6, i3, z, str7, dVar, z2, str8, eVar, str9, i4, arrayList2, arrayList3, i5, i6, str10, str11, arrayList4, z3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq[] newArray(int i) {
        return new eq[i];
    }
}
