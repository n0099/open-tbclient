package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.aq;
/* loaded from: classes.dex */
public class ap implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(aq.b bVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, bVar.b);
        ad.a(parcel, 2, bVar.c, false);
        ad.a(parcel, 3, (Parcelable) bVar.d, i, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public aq.b createFromParcel(Parcel parcel) {
        an.a aVar = null;
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
                    aVar = (an.a) ac.a(parcel, a, an.a.i);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new aq.b(i, str, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public aq.b[] newArray(int i) {
        return new aq.b[i];
    }
}
