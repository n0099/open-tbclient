package com.sdk.base.framework.f.j;

import android.content.Context;
/* loaded from: classes5.dex */
public final class b {
    private static boolean a = false;

    public static boolean a(Context context) {
        Long c = com.sdk.base.framework.f.b.a.c(context, "access_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (c == null) {
            com.sdk.base.framework.f.b.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        } else if (currentTimeMillis - c.longValue() > 600000) {
            com.sdk.base.framework.f.b.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            com.sdk.base.framework.f.b.a.a(context, "access_limit_count", (Long) 0L);
            return true;
        } else {
            Long c2 = com.sdk.base.framework.f.b.a.c(context, "access_limit_count");
            if (c2 != null) {
                return c2.longValue() <= 30;
            }
            com.sdk.base.framework.f.b.a.a(context, "access_limit_count", (Long) 0L);
            return true;
        }
    }

    public static void b(Context context) {
        Long c = com.sdk.base.framework.f.b.a.c(context, "access_limit_count");
        if (c == null) {
            com.sdk.base.framework.f.b.a.a(context, "access_limit_count", (Long) 0L);
        } else {
            com.sdk.base.framework.f.b.a.a(context, "access_limit_count", Long.valueOf(c.longValue() + 1));
        }
    }
}
