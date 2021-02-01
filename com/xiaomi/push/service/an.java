package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private static long f14241a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f927a = "";

    public static String a() {
        if (TextUtils.isEmpty(f927a)) {
            f927a = com.xiaomi.push.bf.a(4);
        }
        StringBuilder append = new StringBuilder().append(f927a);
        long j = f14241a;
        f14241a = 1 + j;
        return append.append(j).toString();
    }
}
