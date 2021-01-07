package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class e implements CacheErrorLogger {
    private static e prP = null;

    private e() {
    }

    public static synchronized e eto() {
        e eVar;
        synchronized (e.class) {
            if (prP == null) {
                prP = new e();
            }
            eVar = prP;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
