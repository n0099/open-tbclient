package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class e implements CacheErrorLogger {
    private static e mPx = null;

    private e() {
    }

    public static synchronized e dBL() {
        e eVar;
        synchronized (e.class) {
            if (mPx == null) {
                mPx = new e();
            }
            eVar = mPx;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
