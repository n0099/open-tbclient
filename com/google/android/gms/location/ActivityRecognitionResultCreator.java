package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.LocationClientOption;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class ActivityRecognitionResultCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.b(parcel, 1, activityRecognitionResult.c, false);
        ad.a(parcel, (int) LocationClientOption.MIN_SCAN_SPAN, activityRecognitionResult.b);
        ad.a(parcel, 2, activityRecognitionResult.d);
        ad.a(parcel, 3, activityRecognitionResult.e);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult();
        int b = ac.b(parcel);
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    activityRecognitionResult.c = ac.c(parcel, a, DetectedActivity.a);
                    break;
                case 2:
                    activityRecognitionResult.d = ac.g(parcel, a);
                    break;
                case 3:
                    activityRecognitionResult.e = ac.g(parcel, a);
                    break;
                case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                    activityRecognitionResult.b = ac.f(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return activityRecognitionResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ActivityRecognitionResult[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
