package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class aq {
    private static long a = 0;
    private static String b = "";

    public static String a() {
        if (TextUtils.isEmpty(b)) {
            b = com.xiaomi.channel.commonutils.string.d.a(4);
        }
        StringBuilder append = new StringBuilder().append(b);
        long j = a;
        a = 1 + j;
        return append.append(j).toString();
    }
}
