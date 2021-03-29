package com.qq.e.comm.managers.status;
/* loaded from: classes6.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    

    /* renamed from: a  reason: collision with root package name */
    public int f38344a;

    /* renamed from: b  reason: collision with root package name */
    public int f38345b;

    /* renamed from: c  reason: collision with root package name */
    public String f38346c;

    NetworkType(int i, int i2, String str) {
        this.f38344a = i;
        this.f38345b = i2;
        this.f38346c = str;
    }

    public final int getConnValue() {
        return this.f38344a;
    }

    public final String getNameValue() {
        return this.f38346c;
    }

    public final int getPermValue() {
        return this.f38345b;
    }
}
