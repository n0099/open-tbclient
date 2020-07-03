package com.heytap.openid.a;

import android.content.Context;
import com.heytap.openid.a.c;
/* loaded from: classes6.dex */
public class a {
    public static void a(Context context) {
        b.b = c.b.ned.a(b.ga(context));
        b.a = true;
    }

    public static boolean a() {
        if (b.a) {
            return b.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (b.a) {
            return c.b.ned.a(b.ga(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.a) {
            return c.b.ned.a(b.ga(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.a) {
            return c.b.ned.a(b.ga(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
