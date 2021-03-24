package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f33836a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f33837b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f33838c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f33839d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f33840e = 204800;

    public static b a() {
        if (f33839d == null) {
            synchronized (b.class) {
                if (f33839d == null) {
                    f33839d = new b();
                }
            }
        }
        return f33839d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f33840e / (f33838c.size() + 1));
            f33838c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f33838c.contains(cVar)) {
                f33838c.remove(cVar);
            }
        }
    }

    public void a(boolean z) {
        f33837b = z;
    }

    public void a(boolean z, int i) {
        if (i > 0) {
            f33840e = i * 1024;
        }
        f33836a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f33836a;
    }

    public int c() {
        return f33840e / 1024;
    }

    public synchronized int d() {
        int i;
        i = 0;
        for (c cVar : f33838c) {
            i += (int) cVar.a();
        }
        return i;
    }
}
