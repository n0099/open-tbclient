package com.pgl.sys.ces;

import android.content.Context;
import d.m.a.b.f;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f38807a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f38808b = 3600;

    /* renamed from: c  reason: collision with root package name */
    public static long f38809c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f38809c >= f38808b) {
                int i2 = 0;
                b.f38795d = false;
                f38807a = 0;
                f38809c = currentTimeMillis;
                while (i2 < 3) {
                    if (!b.f38795d && f38807a < 3) {
                        b(context);
                        f38807a++;
                    }
                    i2++;
                    f.a(i2 * 5000);
                    if (b.f38795d) {
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
