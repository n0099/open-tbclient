package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class e implements CacheErrorLogger {
    private static e lGk = null;

    private e() {
    }

    public static synchronized e diE() {
        e eVar;
        synchronized (e.class) {
            if (lGk == null) {
                lGk = new e();
            }
            eVar = lGk;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
