package com.facebook.cache.common;
/* loaded from: classes13.dex */
public class f implements CacheEventListener {
    private static f mHn = null;

    private f() {
    }

    public static synchronized f dyv() {
        f fVar;
        synchronized (f.class) {
            if (mHn == null) {
                mHn = new f();
            }
            fVar = mHn;
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
