package com.heytap.openid.sdk;

import android.content.Context;
import com.heytap.openid.sdk.c;
/* loaded from: classes6.dex */
public class a {
    public static void a(Context context) {
        b.f31706b = c.b.f31713a.a(b.a(context));
        b.f31705a = true;
    }

    public static boolean a() {
        if (b.f31705a) {
            return b.f31706b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (b.f31705a) {
            return c.b.f31713a.a(b.a(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f31705a) {
            return c.b.f31713a.a(b.a(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f31705a) {
            return c.b.f31713a.a(b.a(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
