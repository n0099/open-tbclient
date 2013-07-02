package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import cn.jingling.lib.file.Shared;
import com.baidu.zeus.WebChromeClient;
import com.google.android.gms.internal.ae;
/* loaded from: classes.dex */
public final class LocationRequest implements ae {
    public static final LocationRequestCreator i = new LocationRequestCreator();
    int a;
    int b = WebChromeClient.STRING_DLG_TITLE_WEEK;
    long c = 3600000;
    long d = (long) (this.c / 6.0d);
    boolean e = false;
    long f = Long.MAX_VALUE;
    int g = Shared.INFINITY;
    float h = 0.0f;

    public static String a(int i2) {
        switch (i2) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case WebChromeClient.STRING_DLG_TITLE_DATETIME /* 101 */:
            case 103:
            default:
                return "???";
            case WebChromeClient.STRING_DLG_TITLE_WEEK /* 102 */:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case WebChromeClient.STRING_DLG_TITLE_TIME /* 104 */:
                return "PRIORITY_LOW_POWER";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(a(this.b));
        if (this.b != 105) {
            sb.append(" requested=");
            sb.append(this.c + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.d + "ms");
        if (this.f != Long.MAX_VALUE) {
            long elapsedRealtime = this.f - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime + "ms");
        }
        if (this.g != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.g);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        LocationRequestCreator locationRequestCreator = i;
        LocationRequestCreator.a(this, parcel, i2);
    }
}
