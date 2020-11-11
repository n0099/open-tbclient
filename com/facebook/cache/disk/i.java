package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes12.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object oKH = new Object();
    private static i oKI;
    private static int oKJ;
    private String mjZ;
    private com.facebook.cache.common.b oKK;
    private long oKL;
    private long oKM;
    private long oKN;
    private CacheEventListener.EvictionReason oKO;
    private i oKP;
    private IOException opK;

    @ReturnsOwnership
    public static i ejT() {
        synchronized (oKH) {
            if (oKI != null) {
                i iVar = oKI;
                oKI = iVar.oKP;
                iVar.oKP = null;
                oKJ--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.oKK = bVar;
        return this;
    }

    public i XX(String str) {
        this.mjZ = str;
        return this;
    }

    public i hB(long j) {
        this.oKL = j;
        return this;
    }

    public i hC(long j) {
        this.oKN = j;
        return this;
    }

    public i hD(long j) {
        this.oKM = j;
        return this;
    }

    public i e(IOException iOException) {
        this.opK = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.oKO = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (oKH) {
            if (oKJ < 5) {
                reset();
                oKJ++;
                if (oKI != null) {
                    this.oKP = oKI;
                }
                oKI = this;
            }
        }
    }

    private void reset() {
        this.oKK = null;
        this.mjZ = null;
        this.oKL = 0L;
        this.oKM = 0L;
        this.oKN = 0L;
        this.opK = null;
        this.oKO = null;
    }
}
