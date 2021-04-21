package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f34221a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f34222b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f34223c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f34224d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f34225e = 204800;

    public static b a() {
        if (f34224d == null) {
            synchronized (b.class) {
                if (f34224d == null) {
                    f34224d = new b();
                }
            }
        }
        return f34224d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f34225e / (f34223c.size() + 1));
            f34223c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f34223c.contains(cVar)) {
                f34223c.remove(cVar);
            }
        }
    }

    public void a(boolean z) {
        f34222b = z;
    }

    public void a(boolean z, int i) {
        if (i > 0) {
            f34225e = i * 1024;
        }
        f34221a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f34221a;
    }

    public int c() {
        return f34225e / 1024;
    }

    public synchronized int d() {
        int i;
        i = 0;
        for (c cVar : f34223c) {
            i += (int) cVar.a();
        }
        return i;
    }
}
