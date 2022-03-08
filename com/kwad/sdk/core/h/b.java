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
    public static volatile boolean f54406b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f54407c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f54408d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f54409e = 204800;

    public static b a() {
        if (f54408d == null) {
            synchronized (b.class) {
                if (f54408d == null) {
                    f54408d = new b();
                }
            }
        }
        return f54408d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f54409e / (f54407c.size() + 1));
            f54407c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f54407c.contains(cVar)) {
                f54407c.remove(cVar);
            }
        }
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f54409e = i2 * 1024;
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
        return f54409e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        try {
            for (c cVar : f54407c) {
                i2 += (int) cVar.a();
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
