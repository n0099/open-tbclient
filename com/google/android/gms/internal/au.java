package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
/* loaded from: classes.dex */
public class au implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(at atVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, atVar.d());
        ad.a(parcel, 2, atVar.e(), false);
        ad.a(parcel, 3, (Parcelable) atVar.f(), i, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public at createFromParcel(Parcel parcel) {
        aq aqVar = null;
        int b = ac.b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    parcel2 = ac.y(parcel, a);
                    break;
                case 3:
                    aqVar = (aq) ac.a(parcel, a, aq.a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new at(i, parcel2, aqVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public at[] newArray(int i) {
        return new at[i];
    }
}
