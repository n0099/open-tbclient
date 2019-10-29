package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e implements CacheErrorLogger {
    private static e jZL = null;

    private e() {
    }

    public static synchronized e cCa() {
        e eVar;
        synchronized (e.class) {
            if (jZL == null) {
                jZL = new e();
            }
            eVar = jZL;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
