package com.heytap.openid.a;

import android.content.Context;
import com.heytap.openid.a.c;
/* loaded from: classes11.dex */
public class a {
    public static void a(Context context) {
        b.b = c.b.pgZ.a(b.hi(context));
        b.f4060a = true;
    }

    public static boolean a() {
        if (b.f4060a) {
            return b.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (b.f4060a) {
            return c.b.pgZ.a(b.hi(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f4060a) {
            return c.b.pgZ.a(b.hi(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f4060a) {
            return c.b.pgZ.a(b.hi(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
