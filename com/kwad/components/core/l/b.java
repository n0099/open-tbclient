package com.kwad.components.core.l;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes9.dex */
public class b {
    public static volatile boolean IA = false;
    public static volatile Set<c> IB = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    public static volatile b Ix = null;
    public static volatile int Iy = 204800;
    public static volatile boolean Iz = true;

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (IB.contains(cVar)) {
                IB.remove(cVar);
            }
        }
    }

    public static void e(boolean z, int i) {
        if (i > 0) {
            Iy = i * 1024;
        }
        Iz = z;
    }

    public static boolean ln() {
        return Iz;
    }

    public static int lo() {
        return Iy / 1024;
    }

    public static b or() {
        if (Ix == null) {
            synchronized (b.class) {
                if (Ix == null) {
                    Ix = new b();
                }
            }
        }
        return Ix;
    }

    public static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, Iy / (IB.size() + 1));
            IB.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final synchronized int lp() {
        int i;
        i = 0;
        try {
            for (c cVar : IB) {
                i += (int) cVar.os();
            }
        } catch (Exception unused) {
        }
        return i;
    }
}
