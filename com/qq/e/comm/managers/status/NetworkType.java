package com.qq.e.comm.managers.status;
/* loaded from: classes6.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    

    /* renamed from: a  reason: collision with root package name */
    public int f36308a;

    /* renamed from: b  reason: collision with root package name */
    public int f36309b;

    /* renamed from: c  reason: collision with root package name */
    public String f36310c;

    NetworkType(int i2, int i3, String str) {
        this.f36308a = i2;
        this.f36309b = i3;
        this.f36310c = str;
    }

    public final int getConnValue() {
        return this.f36308a;
    }

    public final String getNameValue() {
        return this.f36310c;
    }

    public final int getPermValue() {
        return this.f36309b;
    }
}
