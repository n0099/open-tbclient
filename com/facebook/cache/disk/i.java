package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes12.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object nJV = new Object();
    private static i nJW;
    private static int nJX;
    private String lRC;
    private IOException nEd;
    private com.facebook.cache.common.b nJY;
    private long nJZ;
    private long nKa;
    private long nKb;
    private CacheEventListener.EvictionReason nKc;
    private i nKd;

    @ReturnsOwnership
    public static i dWg() {
        synchronized (nJV) {
            if (nJW != null) {
                i iVar = nJW;
                nJW = iVar.nKd;
                iVar.nKd = null;
                nJX--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.nJY = bVar;
        return this;
    }

    public i VG(String str) {
        this.lRC = str;
        return this;
    }

    public i gP(long j) {
        this.nJZ = j;
        return this;
    }

    public i gQ(long j) {
        this.nKb = j;
        return this;
    }

    public i gR(long j) {
        this.nKa = j;
        return this;
    }

    public i e(IOException iOException) {
        this.nEd = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.nKc = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (nJV) {
            if (nJX < 5) {
                reset();
                nJX++;
                if (nJW != null) {
                    this.nKd = nJW;
                }
                nJW = this;
            }
        }
    }

    private void reset() {
        this.nJY = null;
        this.lRC = null;
        this.nJZ = 0L;
        this.nKa = 0L;
        this.nKb = 0L;
        this.nEd = null;
        this.nKc = null;
    }
}
