package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f34562a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f34563b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f34564c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f34565d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f34566e = 204800;

    public static b a() {
        if (f34565d == null) {
            synchronized (b.class) {
                if (f34565d == null) {
                    f34565d = new b();
                }
            }
        }
        return f34565d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f34566e / (f34564c.size() + 1));
            f34564c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f34564c.contains(cVar)) {
                f34564c.remove(cVar);
            }
        }
    }

    public void a(boolean z) {
        f34563b = z;
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f34566e = i2 * 1024;
        }
        f34562a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f34562a;
    }

    public int c() {
        return f34566e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        for (c cVar : f34564c) {
            i2 += (int) cVar.a();
        }
        return i2;
    }
}
