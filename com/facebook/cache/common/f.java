package com.facebook.cache.common;
/* loaded from: classes2.dex */
public class f implements CacheEventListener {
    private static f hVB = null;

    private f() {
    }

    public static synchronized f bQS() {
        f fVar;
        synchronized (f.class) {
            if (hVB == null) {
                hVB = new f();
            }
            fVar = hVB;
        }
        return fVar;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void a(a aVar) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void b(a aVar) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void c(a aVar) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void d(a aVar) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void e(a aVar) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void f(a aVar) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void g(a aVar) {
    }
}
