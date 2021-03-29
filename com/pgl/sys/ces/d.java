package com.pgl.sys.ces;

import android.content.Context;
import d.m.a.b.f;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f38002a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f38003b = 3600;

    /* renamed from: c  reason: collision with root package name */
    public static long f38004c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f38004c >= f38003b) {
                int i = 0;
                b.f37991d = false;
                f38002a = 0;
                f38004c = currentTimeMillis;
                while (i < 3) {
                    if (!b.f37991d && f38002a < 3) {
                        b(context);
                        f38002a++;
                    }
                    i++;
                    f.a(i * 5000);
                    if (b.f37991d) {
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
