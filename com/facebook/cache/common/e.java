package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class e implements CacheErrorLogger {
    private static e mPv = null;

    private e() {
    }

    public static synchronized e dBK() {
        e eVar;
        synchronized (e.class) {
            if (mPv == null) {
                mPv = new e();
            }
            eVar = mPv;
        }
        return eVar;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
