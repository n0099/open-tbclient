package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes5.dex */
public enum b {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_UNKNOWN("mobile");
    

    /* renamed from: g  reason: collision with root package name */
    public String f29213g;

    b(String str) {
        this.f29213g = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f29213g;
    }
}
