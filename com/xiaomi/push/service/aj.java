package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class aj {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f854a = "";

    public static String a() {
        if (TextUtils.isEmpty(f854a)) {
            f854a = com.xiaomi.push.ay.a(4);
        }
        StringBuilder append = new StringBuilder().append(f854a);
        long j = a;
        a = 1 + j;
        return append.append(j).toString();
    }
}
