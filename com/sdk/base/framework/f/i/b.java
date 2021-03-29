package com.sdk.base.framework.f.i;

import android.content.Context;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38563a = false;

    public static boolean a(Context context) {
        Long c2 = com.sdk.base.framework.f.b.a.c(context, "access_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (c2 == null) {
            com.sdk.base.framework.f.b.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        } else if (currentTimeMillis - c2.longValue() > 600000) {
            com.sdk.base.framework.f.b.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            com.sdk.base.framework.f.b.a.a(context, "access_limit_count", (Long) 0L);
            return true;
        } else {
            Long c3 = com.sdk.base.framework.f.b.a.c(context, "access_limit_count");
            if (c3 != null) {
                return c3.longValue() <= 30;
            }
            com.sdk.base.framework.f.b.a.a(context, "access_limit_count", (Long) 0L);
            return true;
        }
    }

    public static void b(Context context) {
        Long c2 = com.sdk.base.framework.f.b.a.c(context, "access_limit_count");
        com.sdk.base.framework.f.b.a.a(context, "access_limit_count", Long.valueOf(c2 == null ? 0L : c2.longValue() + 1));
    }
}
