package com.xiaomi.stats;

import com.xiaomi.push.service.ak;
/* loaded from: classes2.dex */
/* synthetic */ class c {
    static final /* synthetic */ int[] a = new int[ak.c.values().length];

    static {
        try {
            a[ak.c.unbind.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ak.c.binding.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[ak.c.binded.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
