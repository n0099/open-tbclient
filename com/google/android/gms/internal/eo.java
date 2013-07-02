package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.eq;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class eo implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eq.e eVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = eVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, eVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, eVar.f(), true);
        }
        if (d.contains(3)) {
            ad.a(parcel, 3, eVar.h(), true);
        }
        if (d.contains(4)) {
            ad.a(parcel, 4, eVar.i(), true);
        }
        if (d.contains(5)) {
            ad.a(parcel, 5, eVar.j(), true);
        }
        if (d.contains(6)) {
            ad.a(parcel, 6, eVar.k(), true);
        }
        if (d.contains(7)) {
            ad.a(parcel, 7, eVar.l(), true);
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.e createFromParcel(Parcel parcel) {
        String str = null;
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    str6 = ac.l(parcel, a);
                    hashSet.add(2);
                    break;
                case 3:
                    str5 = ac.l(parcel, a);
                    hashSet.add(3);
                    break;
                case 4:
                    str4 = ac.l(parcel, a);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = ac.l(parcel, a);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = ac.l(parcel, a);
                    hashSet.add(6);
                    break;
                case 7:
                    str = ac.l(parcel, a);
                    hashSet.add(7);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new eq.e(hashSet, i, str6, str5, str4, str3, str2, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.e[] newArray(int i) {
        return new eq.e[i];
    }
}
