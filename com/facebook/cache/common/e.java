package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e implements CacheErrorLogger {
    private static e hXk = null;

    private e() {
    }

    public static synchronized e bQm() {
        e eVar;
        synchronized (e.class) {
            if (hXk == null) {
                hXk = new e();
            }
            eVar = hXk;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
