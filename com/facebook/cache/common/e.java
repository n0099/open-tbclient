package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class e implements CacheErrorLogger {
    private static e pAf = null;

    private e() {
    }

    public static synchronized e ese() {
        e eVar;
        synchronized (e.class) {
            if (pAf == null) {
                pAf = new e();
            }
            eVar = pAf;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
