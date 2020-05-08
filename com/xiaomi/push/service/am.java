package com.xiaomi.push.service;

import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
/* loaded from: classes8.dex */
/* synthetic */ class am {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b = new int[ht.values().length];

    static {
        try {
            b[ht.INT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[ht.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[ht.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            b[ht.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        a = new int[hs.values().length];
        try {
            a[hs.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[hs.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
