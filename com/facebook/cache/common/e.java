package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e implements CacheErrorLogger {
    private static e mkg = null;

    private e() {
    }

    public static synchronized e dtD() {
        e eVar;
        synchronized (e.class) {
            if (mkg == null) {
                mkg = new e();
            }
            eVar = mkg;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
