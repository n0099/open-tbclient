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
    public static volatile boolean f55889b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f55890c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f55891d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f55892e = 204800;

    public static b a() {
        if (f55891d == null) {
            synchronized (b.class) {
                if (f55891d == null) {
                    f55891d = new b();
                }
            }
        }
        return f55891d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f55892e / (f55890c.size() + 1));
            f55890c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f55890c.contains(cVar)) {
                f55890c.remove(cVar);
            }
        }
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f55892e = i2 * 1024;
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
        return f55892e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        try {
            for (c cVar : f55890c) {
                i2 += (int) cVar.a();
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
