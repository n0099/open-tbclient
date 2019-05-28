package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e implements CacheErrorLogger {
    private static e jQQ = null;

    private e() {
    }

    public static synchronized e cAT() {
        e eVar;
        synchronized (e.class) {
            if (jQQ == null) {
                jQQ = new e();
            }
            eVar = jQQ;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
