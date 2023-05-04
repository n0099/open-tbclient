package com.xiaomi.push;

import com.xiaomi.push.service.bg;
/* loaded from: classes9.dex */
public /* synthetic */ class fd {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[bg.c.values().length];
        a = iArr;
        try {
            iArr[bg.c.unbind.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[bg.c.binding.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[bg.c.binded.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
