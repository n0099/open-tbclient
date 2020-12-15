package com.heytap.openid.a;

import android.content.Context;
import com.heytap.openid.a.c;
/* loaded from: classes18.dex */
public class a {
    public static void a(Context context) {
        b.b = c.b.pxN.a(b.hQ(context));
        b.f4063a = true;
    }

    public static boolean a() {
        if (b.f4063a) {
            return b.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (b.f4063a) {
            return c.b.pxN.a(b.hQ(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f4063a) {
            return c.b.pxN.a(b.hQ(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f4063a) {
            return c.b.pxN.a(b.hQ(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
