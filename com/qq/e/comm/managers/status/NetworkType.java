package com.qq.e.comm.managers.status;
/* loaded from: classes6.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    

    /* renamed from: a  reason: collision with root package name */
    public int f38633a;

    /* renamed from: b  reason: collision with root package name */
    public int f38634b;

    /* renamed from: c  reason: collision with root package name */
    public String f38635c;

    NetworkType(int i, int i2, String str) {
        this.f38633a = i;
        this.f38634b = i2;
        this.f38635c = str;
    }

    public final int getConnValue() {
        return this.f38633a;
    }

    public final String getNameValue() {
        return this.f38635c;
    }

    public final int getPermValue() {
        return this.f38634b;
    }
}
