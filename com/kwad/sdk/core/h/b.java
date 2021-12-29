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
    public static volatile boolean f58040b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f58041c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f58042d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f58043e = 204800;

    public static b a() {
        if (f58042d == null) {
            synchronized (b.class) {
                if (f58042d == null) {
                    f58042d = new b();
                }
            }
        }
        return f58042d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f58043e / (f58041c.size() + 1));
            f58041c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f58041c.contains(cVar)) {
                f58041c.remove(cVar);
            }
        }
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f58043e = i2 * 1024;
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
        return f58043e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        try {
            for (c cVar : f58041c) {
                i2 += (int) cVar.a();
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
