package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lHO = new Object();
    private static i lHP;
    private static int lHQ;
    private String jwL;
    private com.facebook.cache.common.b lHR;
    private long lHS;
    private long lHT;
    private long lHU;
    private IOException lHV;
    private CacheEventListener.EvictionReason lHW;
    private i lHX;

    @ReturnsOwnership
    public static i dkw() {
        synchronized (lHO) {
            if (lHP != null) {
                i iVar = lHP;
                lHP = iVar.lHX;
                iVar.lHX = null;
                lHQ--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lHR = bVar;
        return this;
    }

    public i OO(String str) {
        this.jwL = str;
        return this;
    }

    public i eV(long j) {
        this.lHS = j;
        return this;
    }

    public i eW(long j) {
        this.lHU = j;
        return this;
    }

    public i eX(long j) {
        this.lHT = j;
        return this;
    }

    public i b(IOException iOException) {
        this.lHV = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lHW = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lHO) {
            if (lHQ < 5) {
                reset();
                lHQ++;
                if (lHP != null) {
                    this.lHX = lHP;
                }
                lHP = this;
            }
        }
    }

    private void reset() {
        this.lHR = null;
        this.jwL = null;
        this.lHS = 0L;
        this.lHT = 0L;
        this.lHU = 0L;
        this.lHV = null;
        this.lHW = null;
    }
}
