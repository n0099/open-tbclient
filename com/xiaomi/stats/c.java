package com.xiaomi.stats;

import com.xiaomi.push.service.as;
/* loaded from: classes3.dex */
/* synthetic */ class c {
    static final /* synthetic */ int[] a = new int[as.c.values().length];

    static {
        try {
            a[as.c.unbind.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[as.c.binding.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[as.c.binded.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
