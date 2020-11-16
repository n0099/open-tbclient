package com.heytap.openid.a;

import android.content.Context;
import com.heytap.openid.a.c;
/* loaded from: classes5.dex */
public class a {
    public static void a(Context context) {
        b.b = c.b.piF.a(b.hg(context));
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
            return c.b.piF.a(b.hg(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f4060a) {
            return c.b.piF.a(b.hg(context), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f4060a) {
            return c.b.piF.a(b.hg(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
