package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e implements CacheErrorLogger {
    private static e hVz = null;

    private e() {
    }

    public static synchronized e bQR() {
        e eVar;
        synchronized (e.class) {
            if (hVz == null) {
                hVz = new e();
            }
            eVar = hVz;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
