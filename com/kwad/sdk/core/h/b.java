package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f32435a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f32436b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f32437c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f32438d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f32439e = 204800;

    public static b a() {
        if (f32438d == null) {
            synchronized (b.class) {
                if (f32438d == null) {
                    f32438d = new b();
                }
            }
        }
        return f32438d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f32439e / (f32437c.size() + 1));
            f32437c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f32437c.contains(cVar)) {
                f32437c.remove(cVar);
            }
        }
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f32439e = i2 * 1024;
        }
        f32435a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f32435a;
    }

    public int c() {
        return f32439e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        for (c cVar : f32437c) {
            i2 += (int) cVar.a();
        }
        return i2;
    }
}
