package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import java.util.List;
/* loaded from: classes.dex */
public class ActivityRecognitionResult implements ae {
    public static final ActivityRecognitionResultCreator a = new ActivityRecognitionResultCreator();
    int b = 1;
    List c;
    long d;
    long e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.c + ", timeMillis=" + this.d + ", elapsedRealtimeMillis=" + this.e + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ActivityRecognitionResultCreator.a(this, parcel, i);
    }
}
