package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jRK = new Object();
    private static i jRL;
    private static int jRM;
    private com.facebook.cache.common.b jRN;
    private long jRO;
    private long jRP;
    private long jRQ;
    private IOException jRR;
    private CacheEventListener.EvictionReason jRS;
    private i jRT;
    private String jRc;

    public static i cBw() {
        synchronized (jRK) {
            if (jRL != null) {
                i iVar = jRL;
                jRL = iVar.jRT;
                iVar.jRT = null;
                jRM--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jRN = bVar;
        return this;
    }

    public i GI(String str) {
        this.jRc = str;
        return this;
    }

    public i eA(long j) {
        this.jRO = j;
        return this;
    }

    public i eB(long j) {
        this.jRQ = j;
        return this;
    }

    public i eC(long j) {
        this.jRP = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jRR = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jRS = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jRK) {
            if (jRM < 5) {
                reset();
                jRM++;
                if (jRL != null) {
                    this.jRT = jRL;
                }
                jRL = this;
            }
        }
    }

    private void reset() {
        this.jRN = null;
        this.jRc = null;
        this.jRO = 0L;
        this.jRP = 0L;
        this.jRQ = 0L;
        this.jRR = null;
        this.jRS = null;
    }
}
