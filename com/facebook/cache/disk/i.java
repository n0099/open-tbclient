package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes3.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object mQp = new Object();
    private static i mQq;
    private static int mQr;
    private String lcR;
    private IOException mLv;
    private com.facebook.cache.common.b mQs;
    private long mQt;
    private long mQu;
    private long mQv;
    private CacheEventListener.EvictionReason mQw;
    private i mQx;

    @ReturnsOwnership
    public static i dCo() {
        synchronized (mQp) {
            if (mQq != null) {
                i iVar = mQq;
                mQq = iVar.mQx;
                iVar.mQx = null;
                mQr--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.mQs = bVar;
        return this;
    }

    public i Rm(String str) {
        this.lcR = str;
        return this;
    }

    public i fU(long j) {
        this.mQt = j;
        return this;
    }

    public i fV(long j) {
        this.mQv = j;
        return this;
    }

    public i fW(long j) {
        this.mQu = j;
        return this;
    }

    public i e(IOException iOException) {
        this.mLv = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.mQw = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (mQp) {
            if (mQr < 5) {
                reset();
                mQr++;
                if (mQq != null) {
                    this.mQx = mQq;
                }
                mQq = this;
            }
        }
    }

    private void reset() {
        this.mQs = null;
        this.lcR = null;
        this.mQt = 0L;
        this.mQu = 0L;
        this.mQv = 0L;
        this.mLv = null;
        this.mQw = null;
    }
}
