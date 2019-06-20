package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jRN = new Object();
    private static i jRO;
    private static int jRP;
    private com.facebook.cache.common.b jRQ;
    private long jRR;
    private long jRS;
    private long jRT;
    private IOException jRU;
    private CacheEventListener.EvictionReason jRV;
    private i jRW;
    private String jRf;

    public static i cBv() {
        synchronized (jRN) {
            if (jRO != null) {
                i iVar = jRO;
                jRO = iVar.jRW;
                iVar.jRW = null;
                jRP--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jRQ = bVar;
        return this;
    }

    public i GK(String str) {
        this.jRf = str;
        return this;
    }

    public i eA(long j) {
        this.jRR = j;
        return this;
    }

    public i eB(long j) {
        this.jRT = j;
        return this;
    }

    public i eC(long j) {
        this.jRS = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jRU = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jRV = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jRN) {
            if (jRP < 5) {
                reset();
                jRP++;
                if (jRO != null) {
                    this.jRW = jRO;
                }
                jRO = this;
            }
        }
    }

    private void reset() {
        this.jRQ = null;
        this.jRf = null;
        this.jRR = 0L;
        this.jRS = 0L;
        this.jRT = 0L;
        this.jRU = null;
        this.jRV = null;
    }
}
