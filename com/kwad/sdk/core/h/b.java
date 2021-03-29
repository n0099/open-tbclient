package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f33837a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f33838b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f33839c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f33840d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f33841e = 204800;

    public static b a() {
        if (f33840d == null) {
            synchronized (b.class) {
                if (f33840d == null) {
                    f33840d = new b();
                }
            }
        }
        return f33840d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f33841e / (f33839c.size() + 1));
            f33839c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f33839c.contains(cVar)) {
                f33839c.remove(cVar);
            }
        }
    }

    public void a(boolean z) {
        f33838b = z;
    }

    public void a(boolean z, int i) {
        if (i > 0) {
            f33841e = i * 1024;
        }
        f33837a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f33837a;
    }

    public int c() {
        return f33841e / 1024;
    }

    public synchronized int d() {
        int i;
        i = 0;
        for (c cVar : f33839c) {
            i += (int) cVar.a();
        }
        return i;
    }
}
