package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.LocationClientOption;
import com.google.android.gms.internal.ac;
/* loaded from: classes.dex */
public class ah implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ag agVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, agVar.b());
        ad.a(parcel, (int) LocationClientOption.MIN_SCAN_SPAN, agVar.a());
        ad.a(parcel, 2, agVar.c());
        ad.a(parcel, 3, agVar.d(), false);
        ad.a(parcel, 4, agVar.e(), false);
        ad.a(parcel, 5, agVar.f(), false);
        ad.a(parcel, 6, agVar.g(), false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ag createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = ac.b(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i2 = ac.f(parcel, a);
                    break;
                case 2:
                    i = ac.f(parcel, a);
                    break;
                case 3:
                    str4 = ac.l(parcel, a);
                    break;
                case 4:
                    str3 = ac.l(parcel, a);
                    break;
                case 5:
                    str2 = ac.l(parcel, a);
                    break;
                case 6:
                    str = ac.l(parcel, a);
                    break;
                case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                    i3 = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new ag(i3, i2, i, str4, str3, str2, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ag[] newArray(int i) {
        return new ag[i];
    }
}
