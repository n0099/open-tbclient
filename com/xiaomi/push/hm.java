package com.xiaomi.push;
/* loaded from: classes5.dex */
public enum hm {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f480a;

    hm(int i) {
        this.f480a = i;
    }

    public static hm a(int i) {
        switch (i) {
            case 1:
                return MISC_CONFIG;
            case 2:
                return PLUGIN_CONFIG;
            default:
                return null;
        }
    }

    public int a() {
        return this.f480a;
    }
}
