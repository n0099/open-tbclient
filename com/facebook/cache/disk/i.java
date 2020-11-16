package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes17.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object oMl = new Object();
    private static i oMm;
    private static int oMn;
    private String mks;
    private com.facebook.cache.common.b oMo;
    private long oMp;
    private long oMq;
    private long oMr;
    private CacheEventListener.EvictionReason oMs;
    private i oMt;
    private IOException oro;

    @ReturnsOwnership
    public static i ejR() {
        synchronized (oMl) {
            if (oMm != null) {
                i iVar = oMm;
                oMm = iVar.oMt;
                iVar.oMt = null;
                oMn--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.oMo = bVar;
        return this;
    }

    public i XI(String str) {
        this.mks = str;
        return this;
    }

    public i hE(long j) {
        this.oMp = j;
        return this;
    }

    public i hF(long j) {
        this.oMr = j;
        return this;
    }

    public i hG(long j) {
        this.oMq = j;
        return this;
    }

    public i e(IOException iOException) {
        this.oro = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.oMs = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (oMl) {
            if (oMn < 5) {
                reset();
                oMn++;
                if (oMm != null) {
                    this.oMt = oMm;
                }
                oMm = this;
            }
        }
    }

    private void reset() {
        this.oMo = null;
        this.mks = null;
        this.oMp = 0L;
        this.oMq = 0L;
        this.oMr = 0L;
        this.oro = null;
        this.oMs = null;
    }
}
