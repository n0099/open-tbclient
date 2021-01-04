package com.heytap.openid.a;

import android.content.Context;
import com.heytap.openid.a.c;
/* loaded from: classes6.dex */
public class a {
    public static void a(Context context) {
        b.f8201b = c.b.pQc.a(b.a(context));
        b.f8200a = true;
    }

    public static boolean a() {
        if (b.f8200a) {
            return b.f8201b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (b.f8200a) {
            return c.b.pQc.a(b.a(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f8200a) {
            return c.b.pQc.a(b.a(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f8200a) {
            return c.b.pQc.a(b.a(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
