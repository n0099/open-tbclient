package com.xiaomi.push;
/* loaded from: classes5.dex */
public enum hs {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f462a;

    hs(int i) {
        this.f462a = i;
    }

    public static hs a(int i) {
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
        return this.f462a;
    }
}
