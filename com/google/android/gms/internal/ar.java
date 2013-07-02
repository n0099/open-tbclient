package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.aq;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ar implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(aq aqVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, aqVar.b());
        ad.b(parcel, 2, aqVar.c(), false);
        ad.a(parcel, 3, aqVar.d(), false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public aq createFromParcel(Parcel parcel) {
        String str = null;
        int b = ac.b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    arrayList = ac.c(parcel, a, aq.a.a);
                    break;
                case 3:
                    str = ac.l(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new aq(i, arrayList, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public aq[] newArray(int i) {
        return new aq[i];
    }
}
