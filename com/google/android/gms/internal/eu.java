package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.eq;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class eu implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eq.i iVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = iVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, iVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, iVar.f());
        }
        if (d.contains(3)) {
            ad.a(parcel, 3, iVar.h());
        }
        if (d.contains(4)) {
            ad.a(parcel, 4, iVar.i(), true);
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.i createFromParcel(Parcel parcel) {
        int i = 0;
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i2 = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    z = ac.c(parcel, a);
                    hashSet.add(2);
                    break;
                case 3:
                    i = ac.f(parcel, a);
                    hashSet.add(3);
                    break;
                case 4:
                    str = ac.l(parcel, a);
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
        return new eq.i(hashSet, i2, z, i, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.i[] newArray(int i) {
        return new eq.i[i];
    }
}
