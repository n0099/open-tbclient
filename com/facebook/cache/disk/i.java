package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lRc = new Object();
    private static i lRd;
    private static int lRe;
    private String kiv;
    private IOException lMO;
    private com.facebook.cache.common.b lRf;
    private long lRg;
    private long lRh;
    private long lRi;
    private CacheEventListener.EvictionReason lRj;
    private i lRk;

    @ReturnsOwnership
    public static i dmP() {
        synchronized (lRc) {
            if (lRd != null) {
                i iVar = lRd;
                lRd = iVar.lRk;
                iVar.lRk = null;
                lRe--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lRf = bVar;
        return this;
    }

    public i NW(String str) {
        this.kiv = str;
        return this;
    }

    public i fC(long j) {
        this.lRg = j;
        return this;
    }

    public i fD(long j) {
        this.lRi = j;
        return this;
    }

    public i fE(long j) {
        this.lRh = j;
        return this;
    }

    public i d(IOException iOException) {
        this.lMO = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lRj = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lRc) {
            if (lRe < 5) {
                reset();
                lRe++;
                if (lRd != null) {
                    this.lRk = lRd;
                }
                lRd = this;
            }
        }
    }

    private void reset() {
        this.lRf = null;
        this.kiv = null;
        this.lRg = 0L;
        this.lRh = 0L;
        this.lRi = 0L;
        this.lMO = null;
        this.lRj = null;
    }
}
