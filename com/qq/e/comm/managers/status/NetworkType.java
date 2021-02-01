package com.qq.e.comm.managers.status;
/* loaded from: classes15.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    

    /* renamed from: a  reason: collision with root package name */
    private int f11569a;

    /* renamed from: b  reason: collision with root package name */
    private int f11570b;
    private String c;

    NetworkType(int i, int i2, String str) {
        this.f11569a = i;
        this.f11570b = i2;
        this.c = str;
    }

    public final int getConnValue() {
        return this.f11569a;
    }

    public final String getNameValue() {
        return this.c;
    }

    public final int getPermValue() {
        return this.f11570b;
    }
}
