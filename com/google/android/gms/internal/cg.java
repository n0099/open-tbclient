package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.LocationClientOption;
import com.google.android.gms.internal.ac;
/* loaded from: classes.dex */
public class cg implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(cf cfVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, cfVar.f(), false);
        ad.a(parcel, (int) LocationClientOption.MIN_SCAN_SPAN, cfVar.a());
        ad.a(parcel, 2, cfVar.g());
        ad.a(parcel, 3, cfVar.b());
        ad.a(parcel, 4, cfVar.c());
        ad.a(parcel, 5, cfVar.d());
        ad.a(parcel, 6, cfVar.e());
        ad.a(parcel, 7, cfVar.h());
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public cf createFromParcel(Parcel parcel) {
        double d = 0.0d;
        short s = 0;
        int b = ac.b(parcel);
        String str = null;
        float f = 0.0f;
        long j = 0;
        double d2 = 0.0d;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    str = ac.l(parcel, a);
                    break;
                case 2:
                    j = ac.g(parcel, a);
                    break;
                case 3:
                    s = ac.e(parcel, a);
                    break;
                case 4:
                    d2 = ac.j(parcel, a);
                    break;
                case 5:
                    d = ac.j(parcel, a);
                    break;
                case 6:
                    f = ac.i(parcel, a);
                    break;
                case 7:
                    i = ac.f(parcel, a);
                    break;
                case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                    i2 = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new cf(i2, str, i, s, d2, d, f, j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public cf[] newArray(int i) {
        return new cf[i];
    }
}
