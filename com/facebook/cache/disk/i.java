package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jYR = new Object();
    private static i jYS;
    private static int jYT;
    private String ixF;
    private com.facebook.cache.common.b jYU;
    private long jYV;
    private long jYW;
    private long jYX;
    private IOException jYY;
    private CacheEventListener.EvictionReason jYZ;
    private i jZa;

    public static i cEw() {
        synchronized (jYR) {
            if (jYS != null) {
                i iVar = jYS;
                jYS = iVar.jZa;
                iVar.jZa = null;
                jYT--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jYU = bVar;
        return this;
    }

    public i HE(String str) {
        this.ixF = str;
        return this;
    }

    public i eI(long j) {
        this.jYV = j;
        return this;
    }

    public i eJ(long j) {
        this.jYX = j;
        return this;
    }

    public i eK(long j) {
        this.jYW = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jYY = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jYZ = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jYR) {
            if (jYT < 5) {
                reset();
                jYT++;
                if (jYS != null) {
                    this.jZa = jYS;
                }
                jYS = this;
            }
        }
    }

    private void reset() {
        this.jYU = null;
        this.ixF = null;
        this.jYV = 0L;
        this.jYW = 0L;
        this.jYX = 0L;
        this.jYY = null;
        this.jYZ = null;
    }
}
