package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e implements CacheErrorLogger {
    private static e lIP = null;

    private e() {
    }

    public static synchronized e dkt() {
        e eVar;
        synchronized (e.class) {
            if (lIP == null) {
                lIP = new e();
            }
            eVar = lIP;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
