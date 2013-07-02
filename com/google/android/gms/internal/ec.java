package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.LocationClientOption;
import com.google.android.gms.internal.ac;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ec implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(eb ebVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, ebVar.b(), false);
        ad.a(parcel, (int) LocationClientOption.MIN_SCAN_SPAN, ebVar.a());
        ad.b(parcel, 2, ebVar.c(), false);
        ad.b(parcel, 3, ebVar.d(), false);
        ad.a(parcel, 4, ebVar.e());
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eb createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int b = ac.b(parcel);
        ArrayList arrayList2 = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    str = ac.l(parcel, a);
                    break;
                case 2:
                    arrayList2 = ac.c(parcel, a, ag.a);
                    break;
                case 3:
                    arrayList = ac.c(parcel, a, ag.a);
                    break;
                case 4:
                    z = ac.c(parcel, a);
                    break;
                case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                    i = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new eb(i, str, arrayList2, arrayList, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public eb[] newArray(int i) {
        return new eb[i];
    }
}
