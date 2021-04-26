package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f33190a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f33191b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f33192c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f33193d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f33194e = 204800;

    public static b a() {
        if (f33193d == null) {
            synchronized (b.class) {
                if (f33193d == null) {
                    f33193d = new b();
                }
            }
        }
        return f33193d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f33194e / (f33192c.size() + 1));
            f33192c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f33192c.contains(cVar)) {
                f33192c.remove(cVar);
            }
        }
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f33194e = i2 * 1024;
        }
        f33190a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f33190a;
    }

    public int c() {
        return f33194e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        for (c cVar : f33192c) {
            i2 += (int) cVar.a();
        }
        return i2;
    }
}
