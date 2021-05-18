package com.qq.e.comm.managers.status;
/* loaded from: classes7.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    

    /* renamed from: a  reason: collision with root package name */
    public int f35553a;

    /* renamed from: b  reason: collision with root package name */
    public int f35554b;

    /* renamed from: c  reason: collision with root package name */
    public String f35555c;

    NetworkType(int i2, int i3, String str) {
        this.f35553a = i2;
        this.f35554b = i3;
        this.f35555c = str;
    }

    public final int getConnValue() {
        return this.f35553a;
    }

    public final String getNameValue() {
        return this.f35555c;
    }

    public final int getPermValue() {
        return this.f35554b;
    }
}
