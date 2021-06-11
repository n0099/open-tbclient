package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes7.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f40999a = false;

    public static void a(Class<?> cls, Context context) {
        if (f40999a) {
            return;
        }
        try {
            f40999a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m56a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> a2 = t.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a2 != null) {
                a(a2, context);
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m56a("mdid:check error " + th);
            return false;
        }
    }
}
