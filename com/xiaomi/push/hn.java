package com.xiaomi.push;
/* loaded from: classes8.dex */
public enum hn {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f494a;

    hn(int i) {
        this.f494a = i;
    }

    public static hn a(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return PLUGIN_CONFIG;
        }
        return MISC_CONFIG;
    }

    public int a() {
        return this.f494a;
    }
}
