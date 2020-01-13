package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class aj {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f852a = "";

    public static String a() {
        if (TextUtils.isEmpty(f852a)) {
            f852a = com.xiaomi.push.ay.a(4);
        }
        StringBuilder append = new StringBuilder().append(f852a);
        long j = a;
        a = 1 + j;
        return append.append(j).toString();
    }
}
