package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f34464a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f34465b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f34466c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f34467d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f34468e = 204800;

    public static b a() {
        if (f34467d == null) {
            synchronized (b.class) {
                if (f34467d == null) {
                    f34467d = new b();
                }
            }
        }
        return f34467d;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, f34468e / (f34466c.size() + 1));
            f34466c.add(cVar);
        }
        return cVar;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f34466c.contains(cVar)) {
                f34466c.remove(cVar);
            }
        }
    }

    public void a(boolean z) {
        f34465b = z;
    }

    public void a(boolean z, int i2) {
        if (i2 > 0) {
            f34468e = i2 * 1024;
        }
        f34464a = z;
    }

    public InputStream b(InputStream inputStream) {
        return a(inputStream);
    }

    public boolean b() {
        return f34464a;
    }

    public int c() {
        return f34468e / 1024;
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        for (c cVar : f34466c) {
            i2 += (int) cVar.a();
        }
        return i2;
    }
}
