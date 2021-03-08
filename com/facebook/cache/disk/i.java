package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object pAX = new Object();
    private static i pAY;
    private static int pAZ;
    private String mKH;
    private IOException oUD;
    private com.facebook.cache.common.b pBa;
    private long pBb;
    private long pBc;
    private long pBd;
    private CacheEventListener.EvictionReason pBe;
    private i pBf;

    @ReturnsOwnership
    public static i esG() {
        synchronized (pAX) {
            if (pAY != null) {
                i iVar = pAY;
                pAY = iVar.pBf;
                iVar.pBf = null;
                pAZ--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.pBa = bVar;
        return this;
    }

    public i Zz(String str) {
        this.mKH = str;
        return this;
    }

    public i iA(long j) {
        this.pBb = j;
        return this;
    }

    public i iB(long j) {
        this.pBd = j;
        return this;
    }

    public i iC(long j) {
        this.pBc = j;
        return this;
    }

    public i h(IOException iOException) {
        this.oUD = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.pBe = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (pAX) {
            if (pAZ < 5) {
                reset();
                pAZ++;
                if (pAY != null) {
                    this.pBf = pAY;
                }
                pAY = this;
            }
        }
    }

    private void reset() {
        this.pBa = null;
        this.mKH = null;
        this.pBb = 0L;
        this.pBc = 0L;
        this.pBd = 0L;
        this.oUD = null;
        this.pBe = null;
    }
}
