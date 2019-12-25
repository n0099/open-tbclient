package com.google.android.exoplayer2.upstream.cache;

import java.io.IOException;
/* loaded from: classes4.dex */
public interface Cache {

    /* loaded from: classes4.dex */
    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }
    }
}
