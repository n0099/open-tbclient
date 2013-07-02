package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class eg implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ef efVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = efVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, efVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, efVar.f(), true);
        }
        if (d.contains(4)) {
            ad.a(parcel, 4, (Parcelable) efVar.h(), i, true);
        }
        if (d.contains(5)) {
            ad.a(parcel, 5, efVar.i(), true);
        }
        if (d.contains(6)) {
            ad.a(parcel, 6, (Parcelable) efVar.j(), i, true);
        }
        if (d.contains(7)) {
            ad.a(parcel, 7, efVar.k(), true);
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ef createFromParcel(Parcel parcel) {
        String str = null;
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ed edVar = null;
        String str2 = null;
        ed edVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    str3 = ac.l(parcel, a);
                    hashSet.add(2);
                    break;
                case 3:
                default:
                    ac.b(parcel, a);
                    break;
                case 4:
                    hashSet.add(4);
                    edVar2 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 5:
                    str2 = ac.l(parcel, a);
                    hashSet.add(5);
                    break;
                case 6:
                    hashSet.add(6);
                    edVar = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 7:
                    str = ac.l(parcel, a);
                    hashSet.add(7);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new ef(hashSet, i, str3, edVar2, str2, edVar, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ef[] newArray(int i) {
        return new ef[i];
    }
}
