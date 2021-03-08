package com.bytedance.sdk.openadsdk.playable;
/* loaded from: classes6.dex */
public enum b {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_UNKNOWN("mobile");
    
    private String g;

    b(String str) {
        this.g = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.g;
    }
}
