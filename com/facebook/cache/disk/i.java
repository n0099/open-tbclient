package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jRJ = new Object();
    private static i jRK;
    private static int jRL;
    private com.facebook.cache.common.b jRM;
    private long jRN;
    private long jRO;
    private long jRP;
    private IOException jRQ;
    private CacheEventListener.EvictionReason jRR;
    private i jRS;
    private String jRb;

    public static i cBu() {
        synchronized (jRJ) {
            if (jRK != null) {
                i iVar = jRK;
                jRK = iVar.jRS;
                iVar.jRS = null;
                jRL--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jRM = bVar;
        return this;
    }

    public i GI(String str) {
        this.jRb = str;
        return this;
    }

    public i eA(long j) {
        this.jRN = j;
        return this;
    }

    public i eB(long j) {
        this.jRP = j;
        return this;
    }

    public i eC(long j) {
        this.jRO = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jRQ = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jRR = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jRJ) {
            if (jRL < 5) {
                reset();
                jRL++;
                if (jRK != null) {
                    this.jRS = jRK;
                }
                jRK = this;
            }
        }
    }

    private void reset() {
        this.jRM = null;
        this.jRb = null;
        this.jRN = 0L;
        this.jRO = 0L;
        this.jRP = 0L;
        this.jRQ = null;
        this.jRR = null;
    }
}
