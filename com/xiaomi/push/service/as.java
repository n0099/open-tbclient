package com.xiaomi.push.service;

import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
/* loaded from: classes7.dex */
public /* synthetic */ class as {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f41840a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f41841b;

    static {
        int[] iArr = new int[hm.values().length];
        f41841b = iArr;
        try {
            iArr[hm.INT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f41841b[hm.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f41841b[hm.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f41841b[hm.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hl.values().length];
        f41840a = iArr2;
        try {
            iArr2[hl.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f41840a[hl.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
