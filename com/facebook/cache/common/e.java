package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class e implements CacheErrorLogger {
    private static e prO = null;

    private e() {
    }

    public static synchronized e etk() {
        e eVar;
        synchronized (e.class) {
            if (prO == null) {
                prO = new e();
            }
            eVar = prO;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
