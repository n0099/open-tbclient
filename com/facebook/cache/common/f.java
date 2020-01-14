package com.facebook.cache.common;
/* loaded from: classes12.dex */
public class f implements CacheEventListener {
    private static f lGq = null;

    private f() {
    }

    public static synchronized f diH() {
        f fVar;
        synchronized (f.class) {
            if (lGq == null) {
                lGq = new f();
            }
            fVar = lGq;
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
