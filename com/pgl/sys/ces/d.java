package com.pgl.sys.ces;

import android.content.Context;
import com.pgl.a.b.f;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f7485a = 0;
    public static long b = 3600;
    public static long c = 0;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - c >= b) {
                b.d = false;
                f7485a = 0;
                c = currentTimeMillis;
                for (int i = 0; i < 3; i++) {
                    if (!b.d && f7485a < 3) {
                        b(context);
                        f7485a++;
                    }
                    f.a((i + 1) * 5000);
                    if (b.d) {
                        break;
                    }
                }
            }
        }
    }

    private static void b(Context context) {
        new com.pgl.sys.ces.c.b(context, b.d()).d(2, 2, null);
    }
}
