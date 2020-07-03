package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object mIf = new Object();
    private static i mIg;
    private static int mIh;
    private String kVw;
    private IOException mDk;
    private com.facebook.cache.common.b mIi;
    private long mIj;
    private long mIk;
    private long mIl;
    private CacheEventListener.EvictionReason mIm;
    private i mIn;

    @ReturnsOwnership
    public static i dyX() {
        synchronized (mIf) {
            if (mIg != null) {
                i iVar = mIg;
                mIg = iVar.mIn;
                iVar.mIn = null;
                mIh--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.mIi = bVar;
        return this;
    }

    public i QA(String str) {
        this.kVw = str;
        return this;
    }

    public i fH(long j) {
        this.mIj = j;
        return this;
    }

    public i fI(long j) {
        this.mIl = j;
        return this;
    }

    public i fJ(long j) {
        this.mIk = j;
        return this;
    }

    public i e(IOException iOException) {
        this.mDk = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.mIm = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (mIf) {
            if (mIh < 5) {
                reset();
                mIh++;
                if (mIg != null) {
                    this.mIn = mIg;
                }
                mIg = this;
            }
        }
    }

    private void reset() {
        this.mIi = null;
        this.kVw = null;
        this.mIj = 0L;
        this.mIk = 0L;
        this.mIl = 0L;
        this.mDk = null;
        this.mIm = null;
    }
}
