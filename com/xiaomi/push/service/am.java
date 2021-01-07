package com.xiaomi.push.service;

import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
/* loaded from: classes6.dex */
/* synthetic */ class am {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f14537a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ int[] f14538b = new int[ht.values().length];

    static {
        try {
            f14538b[ht.INT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f14538b[ht.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f14538b[ht.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f14538b[ht.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f14537a = new int[hs.values().length];
        try {
            f14537a[hs.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f14537a[hs.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
