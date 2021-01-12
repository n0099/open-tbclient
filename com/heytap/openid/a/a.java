package com.heytap.openid.a;

import android.content.Context;
import com.heytap.openid.a.c;
/* loaded from: classes5.dex */
public class a {
    public static void a(Context context) {
        b.f7902b = c.b.pNk.a(b.a(context));
        b.f7901a = true;
    }

    public static boolean a() {
        if (b.f7901a) {
            return b.f7902b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (b.f7901a) {
            return c.b.pNk.a(b.a(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f7901a) {
            return c.b.pNk.a(b.a(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f7901a) {
            return c.b.pNk.a(b.a(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
