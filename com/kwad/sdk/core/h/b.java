package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
public class b {
    public static volatile boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f55844b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f55845c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f55846d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f55847e = 204800;

    public static b a() {
        if (f55846d == null) {
            synchronized (b.class) {
                if (f55846d == null) {
                    f55846d = new b();
                }
            }
        }
        return f55846d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f55847e / (f55845c.size() + 1));
            f55845c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f55845c.contains(cVar)) {
                f55845c.remove(cVar);
            }
        }
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f55847e = i2 * 1024;
        }
        a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return a;
    }

    public int c() {
        return f55847e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        try {
            for (c cVar : f55845c) {
                i2 += (int) cVar.a();
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
