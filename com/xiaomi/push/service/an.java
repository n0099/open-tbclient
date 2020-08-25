package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class an {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f850a = "";

    public static String a() {
        if (TextUtils.isEmpty(f850a)) {
            f850a = com.xiaomi.push.bf.a(4);
        }
        StringBuilder append = new StringBuilder().append(f850a);
        long j = a;
        a = 1 + j;
        return append.append(j).toString();
    }
}
