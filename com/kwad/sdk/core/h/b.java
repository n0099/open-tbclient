package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f34126a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f34127b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f34128c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f34129d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f34130e = 204800;

    public static b a() {
        if (f34129d == null) {
            synchronized (b.class) {
                if (f34129d == null) {
                    f34129d = new b();
                }
            }
        }
        return f34129d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f34130e / (f34128c.size() + 1));
            f34128c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f34128c.contains(cVar)) {
                f34128c.remove(cVar);
            }
        }
    }

    public void a(boolean z) {
        f34127b = z;
    }

    public void a(boolean z, int i) {
        if (i > 0) {
            f34130e = i * 1024;
        }
        f34126a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f34126a;
    }

    public int c() {
        return f34130e / 1024;
    }

    public synchronized int d() {
        int i;
        i = 0;
        for (c cVar : f34128c) {
            i += (int) cVar.a();
        }
        return i;
    }
}
