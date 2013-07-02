package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ak;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class al implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ak akVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, akVar.a());
        ad.b(parcel, 2, akVar.b(), false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ak createFromParcel(Parcel parcel) {
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
                    arrayList = ac.c(parcel, a, ak.a.a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new ak(i, arrayList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ak[] newArray(int i) {
        return new ak[i];
    }
}
