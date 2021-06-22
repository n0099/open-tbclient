package com.pgl.sys.ces;

import android.content.Context;
import d.m.a.b.f;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f38905a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f38906b = 3600;

    /* renamed from: c  reason: collision with root package name */
    public static long f38907c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f38907c >= f38906b) {
                int i2 = 0;
                b.f38893d = false;
                f38905a = 0;
                f38907c = currentTimeMillis;
                while (i2 < 3) {
                    if (!b.f38893d && f38905a < 3) {
                        b(context);
                        f38905a++;
                    }
                    i2++;
                    f.a(i2 * 5000);
                    if (b.f38893d) {
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
