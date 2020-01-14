package com.xiaomi.push;
/* loaded from: classes6.dex */
public enum hm {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f479a;

    hm(int i) {
        this.f479a = i;
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
        return this.f479a;
    }
}
