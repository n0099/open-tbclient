package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    public static long f38886a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static String f897a = "";

    public static String a() {
        if (TextUtils.isEmpty(f897a)) {
            f897a = com.xiaomi.push.bm.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f897a);
        long j = f38886a;
        f38886a = 1 + j;
        sb.append(j);
        return sb.toString();
    }
}
