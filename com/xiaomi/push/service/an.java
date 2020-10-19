package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private static long f5056a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f849a = "";

    public static String a() {
        if (TextUtils.isEmpty(f849a)) {
            f849a = com.xiaomi.push.bf.a(4);
        }
        StringBuilder append = new StringBuilder().append(f849a);
        long j = f5056a;
        f5056a = 1 + j;
        return append.append(j).toString();
    }
}
