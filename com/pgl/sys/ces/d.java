package com.pgl.sys.ces;

import android.content.Context;
import d.n.a.b.f;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f38386a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f38387b = 3600;

    /* renamed from: c  reason: collision with root package name */
    public static long f38388c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f38388c >= f38387b) {
                int i = 0;
                b.f38375d = false;
                f38386a = 0;
                f38388c = currentTimeMillis;
                while (i < 3) {
                    if (!b.f38375d && f38386a < 3) {
                        b(context);
                        f38386a++;
                    }
                    i++;
                    f.a(i * 5000);
                    if (b.f38375d) {
                        break;
                    }
                }
            }
        }
    }

    public static void b(Context context) {
        new d.n.b.b.c.b(context, b.d()).d(2, 2, null);
    }
}
