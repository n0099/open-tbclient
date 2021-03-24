package com.xiaomi.push;
/* loaded from: classes7.dex */
public enum hl {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f492a;

    hl(int i) {
        this.f492a = i;
    }

    public static hl a(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return PLUGIN_CONFIG;
        }
        return MISC_CONFIG;
    }

    public int a() {
        return this.f492a;
    }
}
