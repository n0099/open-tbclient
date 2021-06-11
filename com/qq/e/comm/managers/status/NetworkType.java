package com.qq.e.comm.managers.status;
/* loaded from: classes7.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    

    /* renamed from: a  reason: collision with root package name */
    public int f39161a;

    /* renamed from: b  reason: collision with root package name */
    public int f39162b;

    /* renamed from: c  reason: collision with root package name */
    public String f39163c;

    NetworkType(int i2, int i3, String str) {
        this.f39161a = i2;
        this.f39162b = i3;
        this.f39163c = str;
    }

    public final int getConnValue() {
        return this.f39161a;
    }

    public final String getNameValue() {
        return this.f39163c;
    }

    public final int getPermValue() {
        return this.f39162b;
    }
}
