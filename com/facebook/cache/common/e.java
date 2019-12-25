package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class e implements CacheErrorLogger {
    private static e lCM = null;

    private e() {
    }

    public static synchronized e dhD() {
        e eVar;
        synchronized (e.class) {
            if (lCM == null) {
                lCM = new e();
            }
            eVar = lCM;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
