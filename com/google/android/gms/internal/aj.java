package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
/* loaded from: classes.dex */
public class aj implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ai aiVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, aiVar.a());
        ad.a(parcel, 2, (Parcelable) aiVar.b(), i, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ai createFromParcel(Parcel parcel) {
        int b = ac.b(parcel);
        int i = 0;
        ak akVar = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    akVar = (ak) ac.a(parcel, a, ak.a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new ai(i, akVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ai[] newArray(int i) {
        return new ai[i];
    }
}
