package com.xiaomi.push.service;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class bd {
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static String f920a = "";

    public static String a() {
        if (TextUtils.isEmpty(f920a)) {
            f920a = com.xiaomi.push.bo.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f920a);
        long j = a;
        a = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. " + e);
            return "UnexpectedId";
        }
    }

    public static String b() {
        return com.xiaomi.push.bo.a(32);
    }
}
