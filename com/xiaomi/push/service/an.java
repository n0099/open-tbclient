package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private static long f5054a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f846a = "";

    public static String a() {
        if (TextUtils.isEmpty(f846a)) {
            f846a = com.xiaomi.push.bf.a(4);
        }
        StringBuilder append = new StringBuilder().append(f846a);
        long j = f5054a;
        f5054a = 1 + j;
        return append.append(j).toString();
    }
}
