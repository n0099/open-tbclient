package com.facebook.cache.common;
/* loaded from: classes2.dex */
public class f implements CacheEventListener {
    private static f jZM = null;

    private f() {
    }

    public static synchronized f cCb() {
        f fVar;
        synchronized (f.class) {
            if (jZM == null) {
                jZM = new f();
            }
            fVar = jZM;
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
