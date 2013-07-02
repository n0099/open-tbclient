package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.LocationClientOption;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class DetectedActivityCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, detectedActivity.c);
        ad.a(parcel, (int) LocationClientOption.MIN_SCAN_SPAN, detectedActivity.b);
        ad.a(parcel, 2, detectedActivity.d);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DetectedActivity createFromParcel(Parcel parcel) {
        DetectedActivity detectedActivity = new DetectedActivity();
        int b = ac.b(parcel);
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    detectedActivity.c = ac.f(parcel, a);
                    break;
                case 2:
                    detectedActivity.d = ac.f(parcel, a);
                    break;
                case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                    detectedActivity.b = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return detectedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DetectedActivity[] newArray(int i) {
        return new DetectedActivity[i];
    }
}
