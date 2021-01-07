package com.heytap.openid.a;

import android.content.Context;
import com.heytap.openid.a.c;
/* loaded from: classes5.dex */
public class a {
    public static void a(Context context) {
        b.f8202b = c.b.pRK.a(b.a(context));
        b.f8201a = true;
    }

    public static boolean a() {
        if (b.f8201a) {
            return b.f8202b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (b.f8201a) {
            return c.b.pRK.a(b.a(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f8201a) {
            return c.b.pRK.a(b.a(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f8201a) {
            return c.b.pRK.a(b.a(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
