package com.tencent.map.geoloclite.tsa;

import android.os.Bundle;
/* loaded from: classes3.dex */
public interface TencentLiteLocation {
    public static final String GPS_PROVIDER = "gps";
    public static final String NETWORK_PROVIDER = "network";

    float getAccuracy();

    double getAltitude();

    long getElapsedRealtime();

    Bundle getExtra();

    double getLatitude();

    double getLongitude();

    String getProvider();

    float getSpeed();

    long getTime();
}
