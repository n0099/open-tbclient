package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object mIi = new Object();
    private static i mIj;
    private static int mIk;
    private String kVw;
    private IOException mDn;
    private com.facebook.cache.common.b mIl;
    private long mIm;
    private long mIn;
    private long mIo;
    private CacheEventListener.EvictionReason mIq;
    private i mIr;

    @ReturnsOwnership
    public static i dzb() {
        synchronized (mIi) {
            if (mIj != null) {
                i iVar = mIj;
                mIj = iVar.mIr;
                iVar.mIr = null;
                mIk--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.mIl = bVar;
        return this;
    }

    public i QB(String str) {
        this.kVw = str;
        return this;
    }

    public i fH(long j) {
        this.mIm = j;
        return this;
    }

    public i fI(long j) {
        this.mIo = j;
        return this;
    }

    public i fJ(long j) {
        this.mIn = j;
        return this;
    }

    public i e(IOException iOException) {
        this.mDn = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.mIq = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (mIi) {
            if (mIk < 5) {
                reset();
                mIk++;
                if (mIj != null) {
                    this.mIr = mIj;
                }
                mIj = this;
            }
        }
    }

    private void reset() {
        this.mIl = null;
        this.kVw = null;
        this.mIm = 0L;
        this.mIn = 0L;
        this.mIo = 0L;
        this.mDn = null;
        this.mIq = null;
    }
}
