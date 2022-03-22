package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class b {
    public static volatile boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f39530b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f39531c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f39532d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f39533e = 204800;

    public static b a() {
        if (f39532d == null) {
            synchronized (b.class) {
                if (f39532d == null) {
                    f39532d = new b();
                }
            }
        }
        return f39532d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f39533e / (f39531c.size() + 1));
            f39531c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f39531c.contains(cVar)) {
                f39531c.remove(cVar);
            }
        }
    }

    public void a(boolean z, int i) {
        if (i > 0) {
            f39533e = i * 1024;
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
        return f39533e / 1024;
    }

    public synchronized int d() {
        int i;
        i = 0;
        try {
            for (c cVar : f39531c) {
                i += (int) cVar.a();
            }
        } catch (Exception unused) {
        }
        return i;
    }
}
