package com.tencent.map.geoloclite.tsa;
/* loaded from: classes3.dex */
public interface TencentLiteLocationListener {
    public static final String CELL = "cell";
    public static final String GPS = "gps";
    public static final int STATUS_DENIED = 2;
    public static final int STATUS_DISABLED = 0;
    public static final int STATUS_ENABLED = 1;
    public static final int STATUS_LOCATION_SWITCH_OFF = 5;
    public static final int STATUS_UNKNOWN = -1;
    public static final String WIFI = "wifi";

    void onLocationChanged(TencentLiteLocation tencentLiteLocation, int i, String str);

    void onStatusUpdate(String str, int i, String str2);
}
