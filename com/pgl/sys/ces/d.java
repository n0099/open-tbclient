package com.pgl.sys.ces;

import android.content.Context;
import d.m.a.b.f;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f38001a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static long f38002b = 3600;

    /* renamed from: c  reason: collision with root package name */
    public static long f38003c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f38003c >= f38002b) {
                int i = 0;
                b.f37990d = false;
                f38001a = 0;
                f38003c = currentTimeMillis;
                while (i < 3) {
                    if (!b.f37990d && f38001a < 3) {
                        b(context);
                        f38001a++;
                    }
                    i++;
                    f.a(i * 5000);
                    if (b.f37990d) {
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
