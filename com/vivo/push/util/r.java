package com.vivo.push.util;
/* loaded from: classes8.dex */
public final class r {
    public static int a(com.vivo.push.b.c cVar) {
        w b = w.b();
        int b2 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int b3 = b.b("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT");
        long b4 = b.b("com.vivo.push_preferences.operate." + b2 + "START_TIME", 0L);
        if (currentTimeMillis - b4 > 86400000 || currentTimeMillis - b4 < 0) {
            b.a("com.vivo.push_preferences.operate." + b2 + "START_TIME", System.currentTimeMillis());
            b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", 1);
        } else if (b3 >= cVar.f()) {
            return 1001;
        } else {
            b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", b3 + 1);
        }
        return 0;
    }
}
