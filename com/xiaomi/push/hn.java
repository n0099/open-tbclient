package com.xiaomi.push;
/* loaded from: classes10.dex */
public enum hn {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f490a;

    hn(int i) {
        this.f490a = i;
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
        return this.f490a;
    }
}
