package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e implements CacheErrorLogger {
    private static e mHm = null;

    private e() {
    }

    public static synchronized e dyu() {
        e eVar;
        synchronized (e.class) {
            if (mHm == null) {
                mHm = new e();
            }
            eVar = mHm;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
