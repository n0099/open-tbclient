package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class e implements CacheErrorLogger {
    private static e pnk = null;

    private e() {
    }

    public static synchronized e epu() {
        e eVar;
        synchronized (e.class) {
            if (pnk == null) {
                pnk = new e();
            }
            eVar = pnk;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
