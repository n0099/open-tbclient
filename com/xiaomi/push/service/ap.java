package com.xiaomi.push.service;
/* loaded from: classes3.dex */
/* synthetic */ class ap {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b = new int[com.xiaomi.xmpush.thrift.i.values().length];

    static {
        try {
            b[com.xiaomi.xmpush.thrift.i.INT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[com.xiaomi.xmpush.thrift.i.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[com.xiaomi.xmpush.thrift.i.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            b[com.xiaomi.xmpush.thrift.i.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        a = new int[com.xiaomi.xmpush.thrift.h.values().length];
        try {
            a[com.xiaomi.xmpush.thrift.h.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[com.xiaomi.xmpush.thrift.h.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
