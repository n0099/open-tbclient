package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes3.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object mQn = new Object();
    private static i mQo;
    private static int mQp;
    private String lcP;
    private IOException mLt;
    private com.facebook.cache.common.b mQq;
    private long mQr;
    private long mQs;
    private long mQt;
    private CacheEventListener.EvictionReason mQu;
    private i mQv;

    @ReturnsOwnership
    public static i dCn() {
        synchronized (mQn) {
            if (mQo != null) {
                i iVar = mQo;
                mQo = iVar.mQv;
                iVar.mQv = null;
                mQp--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.mQq = bVar;
        return this;
    }

    public i Rm(String str) {
        this.lcP = str;
        return this;
    }

    public i fU(long j) {
        this.mQr = j;
        return this;
    }

    public i fV(long j) {
        this.mQt = j;
        return this;
    }

    public i fW(long j) {
        this.mQs = j;
        return this;
    }

    public i e(IOException iOException) {
        this.mLt = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.mQu = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (mQn) {
            if (mQp < 5) {
                reset();
                mQp++;
                if (mQo != null) {
                    this.mQv = mQo;
                }
                mQo = this;
            }
        }
    }

    private void reset() {
        this.mQq = null;
        this.lcP = null;
        this.mQr = 0L;
        this.mQs = 0L;
        this.mQt = 0L;
        this.mLt = null;
        this.mQu = null;
    }
}
