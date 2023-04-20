package com.xiaomi.push.service;

import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
/* loaded from: classes9.dex */
public /* synthetic */ class bc {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[ho.values().length];
        b = iArr;
        try {
            iArr[ho.INT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[ho.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[ho.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[ho.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hn.values().length];
        a = iArr2;
        try {
            iArr2[hn.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hn.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
