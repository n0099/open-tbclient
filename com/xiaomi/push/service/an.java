package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private static long f14539a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f928a = "";

    public static String a() {
        if (TextUtils.isEmpty(f928a)) {
            f928a = com.xiaomi.push.bf.a(4);
        }
        StringBuilder append = new StringBuilder().append(f928a);
        long j = f14539a;
        f14539a = 1 + j;
        return append.append(j).toString();
    }
}
