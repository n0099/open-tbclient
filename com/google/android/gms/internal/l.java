package com.google.android.gms.internal;

import android.database.CursorWindow;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.LocationClientOption;
import com.google.android.gms.internal.ac;
/* loaded from: classes.dex */
public class l implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(k kVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, kVar.c, false);
        ad.a(parcel, (int) LocationClientOption.MIN_SCAN_SPAN, kVar.b);
        ad.a(parcel, 2, (Parcelable[]) kVar.e, i, false);
        ad.a(parcel, 3, kVar.f);
        ad.a(parcel, 4, kVar.g, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public k createFromParcel(Parcel parcel) {
        k kVar = new k();
        int b = ac.b(parcel);
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    kVar.c = ac.w(parcel, a);
                    break;
                case 2:
                    kVar.e = (CursorWindow[]) ac.b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    kVar.f = ac.f(parcel, a);
                    break;
                case 4:
                    kVar.g = ac.n(parcel, a);
                    break;
                case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                    kVar.b = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        kVar.a();
        return kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public k[] newArray(int i) {
        return new k[i];
    }
}
