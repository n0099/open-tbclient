package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes18.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private static long f5056a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f851a = "";

    public static String a() {
        if (TextUtils.isEmpty(f851a)) {
            f851a = com.xiaomi.push.bf.a(4);
        }
        StringBuilder append = new StringBuilder().append(f851a);
        long j = f5056a;
        f5056a = 1 + j;
        return append.append(j).toString();
    }
}
