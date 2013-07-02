package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
/* loaded from: classes.dex */
public class DetectedActivity implements ae {
    public static final DetectedActivityCreator a = new DetectedActivityCreator();
    int b = 1;
    int c;
    int d;

    private int a(int i) {
        if (i > 5) {
            return 4;
        }
        return i;
    }

    public int a() {
        return a(this.c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DetectedActivity [type=" + a() + ", confidence=" + this.d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        DetectedActivityCreator.a(this, parcel, i);
    }
}
