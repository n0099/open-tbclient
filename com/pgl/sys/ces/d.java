package com.pgl.sys.ces;

import android.content.Context;
import d.m.a.b.f;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f35128a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f35129b = 3600;

    /* renamed from: c  reason: collision with root package name */
    public static long f35130c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f35130c >= f35129b) {
                int i2 = 0;
                b.f35116d = false;
                f35128a = 0;
                f35130c = currentTimeMillis;
                while (i2 < 3) {
                    if (!b.f35116d && f35128a < 3) {
                        b(context);
                        f35128a++;
                    }
                    i2++;
                    f.a(i2 * 5000);
                    if (b.f35116d) {
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
