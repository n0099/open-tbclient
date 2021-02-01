package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class e implements CacheErrorLogger {
    private static e pxA = null;

    private e() {
    }

    public static synchronized e erN() {
        e eVar;
        synchronized (e.class) {
            if (pxA == null) {
                pxA = new e();
            }
            eVar = pxA;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
