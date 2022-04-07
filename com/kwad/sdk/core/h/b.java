package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class b {
    public static volatile boolean a = true;
    public static volatile boolean b = false;
    public static volatile Set<c> c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    public static volatile b d = null;
    public static volatile int e = 204800;

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

    public void a(boolean z, int i) {
        if (i > 0) {
            e = i * 1024;
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
        return e / 1024;
    }

    public synchronized int d() {
        int i;
        i = 0;
        try {
            for (c cVar : c) {
                i += (int) cVar.a();
            }
        } catch (Exception unused) {
        }
        return i;
    }
}
