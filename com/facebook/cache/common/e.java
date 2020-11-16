package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class e implements CacheErrorLogger {
    private static e oLt = null;

    private e() {
    }

    public static synchronized e ejo() {
        e eVar;
        synchronized (e.class) {
            if (oLt == null) {
                oLt = new e();
            }
            eVar = oLt;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
