package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class e implements CacheErrorLogger {
    private static e lGp = null;

    private e() {
    }

    public static synchronized e diG() {
        e eVar;
        synchronized (e.class) {
            if (lGp == null) {
                lGp = new e();
            }
            eVar = lGp;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
