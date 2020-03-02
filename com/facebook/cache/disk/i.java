package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lHQ = new Object();
    private static i lHR;
    private static int lHS;
    private String jwN;
    private com.facebook.cache.common.b lHT;
    private long lHU;
    private long lHV;
    private long lHW;
    private IOException lHX;
    private CacheEventListener.EvictionReason lHY;
    private i lHZ;

    @ReturnsOwnership
    public static i dky() {
        synchronized (lHQ) {
            if (lHR != null) {
                i iVar = lHR;
                lHR = iVar.lHZ;
                iVar.lHZ = null;
                lHS--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lHT = bVar;
        return this;
    }

    public i OO(String str) {
        this.jwN = str;
        return this;
    }

    public i eV(long j) {
        this.lHU = j;
        return this;
    }

    public i eW(long j) {
        this.lHW = j;
        return this;
    }

    public i eX(long j) {
        this.lHV = j;
        return this;
    }

    public i b(IOException iOException) {
        this.lHX = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lHY = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lHQ) {
            if (lHS < 5) {
                reset();
                lHS++;
                if (lHR != null) {
                    this.lHZ = lHR;
                }
                lHR = this;
            }
        }
    }

    private void reset() {
        this.lHT = null;
        this.jwN = null;
        this.lHU = 0L;
        this.lHV = 0L;
        this.lHW = 0L;
        this.lHX = null;
        this.lHY = null;
    }
}
