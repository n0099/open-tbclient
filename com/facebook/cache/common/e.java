package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class e implements CacheErrorLogger {
    private static e paD = null;

    private e() {
    }

    public static synchronized e epf() {
        e eVar;
        synchronized (e.class) {
            if (paD == null) {
                paD = new e();
            }
            eVar = paD;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
