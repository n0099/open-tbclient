package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.eq;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class en implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eq.d dVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = dVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, dVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, dVar.f(), true);
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.d createFromParcel(Parcel parcel) {
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
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
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new eq.d(hashSet, i, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eq.d[] newArray(int i) {
        return new eq.d[i];
    }
}
