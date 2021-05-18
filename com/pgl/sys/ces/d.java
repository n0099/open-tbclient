package com.pgl.sys.ces;

import android.content.Context;
import d.m.a.b.f;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f35199a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f35200b = 3600;

    /* renamed from: c  reason: collision with root package name */
    public static long f35201c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f35201c >= f35200b) {
                int i2 = 0;
                b.f35187d = false;
                f35199a = 0;
                f35201c = currentTimeMillis;
                while (i2 < 3) {
                    if (!b.f35187d && f35199a < 3) {
                        b(context);
                        f35199a++;
                    }
                    i2++;
                    f.a(i2 * 5000);
                    if (b.f35187d) {
                        break;
                    }
                }
            }
        }
    }

    public static void b(Context context) {
        new d.m.b.b.c.b(context, b.d()).d(2, 2, null);
    }
}
