package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class an {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f853a = "";

    public static String a() {
        if (TextUtils.isEmpty(f853a)) {
            f853a = com.xiaomi.push.bf.a(4);
        }
        StringBuilder append = new StringBuilder().append(f853a);
        long j = a;
        a = 1 + j;
        return append.append(j).toString();
    }
}
