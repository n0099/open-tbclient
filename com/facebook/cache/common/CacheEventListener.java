package com.facebook.cache.common;
/* loaded from: classes13.dex */
public interface CacheEventListener {

    /* loaded from: classes13.dex */
    public enum EvictionReason {
        CACHE_FULL,
        CONTENT_STALE,
        USER_FORCED,
        CACHE_MANAGER_TRIMMED
    }

    void a(a aVar);

    void b(a aVar);

    void c(a aVar);

    void d(a aVar);

    void e(a aVar);

    void f(a aVar);

    void g(a aVar);
}
