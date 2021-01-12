package com.pgl.sys.ces;

import android.content.Context;
import com.pgl.a.b.f;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f11406a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f11407b = 3600;
    public static long c = 0;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - c >= f11407b) {
                b.d = false;
                f11406a = 0;
                c = currentTimeMillis;
                for (int i = 0; i < 3; i++) {
                    if (!b.d && f11406a < 3) {
                        b(context);
                        f11406a++;
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
