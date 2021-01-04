package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b d;
    private static volatile int e = com.baidu.fsg.base.statistics.b.f1984b;

    /* renamed from: a  reason: collision with root package name */
    static volatile boolean f9602a = true;

    /* renamed from: b  reason: collision with root package name */
    static volatile boolean f9603b = false;
    static volatile Set<c> c = Collections.newSetFromMap(new WeakHashMap());

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, e / (c.size() + 1));
            c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (c.contains(cVar)) {
                c.remove(cVar);
            }
        }
    }

    public void a(boolean z) {
        f9603b = z;
    }

    public void a(boolean z, int i) {
        if (i > 0) {
            e = i * 1024;
        }
        f9602a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f9602a;
    }

    public int c() {
        return e / 1024;
    }

    public synchronized int d() {
        int i;
        int i2 = 0;
        Iterator<c> it = c.iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                i2 = ((int) it.next().a()) + i;
            }
        }
        return i;
    }
}
