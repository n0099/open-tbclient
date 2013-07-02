package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.aq;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class as implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(aq.a aVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, aVar.b);
        ad.a(parcel, 2, aVar.c, false);
        ad.b(parcel, 3, aVar.d, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public aq.a createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int b = ac.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    str = ac.l(parcel, a);
                    break;
                case 3:
                    arrayList = ac.c(parcel, a, aq.b.a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new aq.a(i, str, arrayList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public aq.a[] newArray(int i) {
        return new aq.a[i];
    }
}
