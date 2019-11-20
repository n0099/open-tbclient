package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jZM = new Object();
    private static i jZN;
    private static int jZO;
    private String iyq;
    private com.facebook.cache.common.b jZP;
    private long jZQ;
    private long jZR;
    private long jZS;
    private IOException jZT;
    private CacheEventListener.EvictionReason jZU;
    private i jZV;

    public static i cCB() {
        synchronized (jZM) {
            if (jZN != null) {
                i iVar = jZN;
                jZN = iVar.jZV;
                iVar.jZV = null;
                jZO--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jZP = bVar;
        return this;
    }

    public i Gw(String str) {
        this.iyq = str;
        return this;
    }

    public i ee(long j) {
        this.jZQ = j;
        return this;
    }

    public i ef(long j) {
        this.jZS = j;
        return this;
    }

    public i eg(long j) {
        this.jZR = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jZT = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jZU = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jZM) {
            if (jZO < 5) {
                reset();
                jZO++;
                if (jZN != null) {
                    this.jZV = jZN;
                }
                jZN = this;
            }
        }
    }

    private void reset() {
        this.jZP = null;
        this.iyq = null;
        this.jZQ = 0L;
        this.jZR = 0L;
        this.jZS = 0L;
        this.jZT = null;
        this.jZU = null;
    }
}
