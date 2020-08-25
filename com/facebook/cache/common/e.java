package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class e implements CacheErrorLogger {
    private static e njs = null;

    private e() {
    }

    public static synchronized e dNL() {
        e eVar;
        synchronized (e.class) {
            if (njs == null) {
                njs = new e();
            }
            eVar = njs;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
