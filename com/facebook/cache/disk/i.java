package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object psH = new Object();
    private static i psI;
    private static int psJ;
    private String mDO;
    private IOException oMu;
    private com.facebook.cache.common.b psK;
    private long psL;
    private long psM;
    private long psN;
    private CacheEventListener.EvictionReason psO;
    private i psP;

    @ReturnsOwnership
    public static i etQ() {
        synchronized (psH) {
            if (psI != null) {
                i iVar = psI;
                psI = iVar.psP;
                iVar.psP = null;
                psJ--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.psK = bVar;
        return this;
    }

    public i Zn(String str) {
        this.mDO = str;
        return this;
    }

    public i ix(long j) {
        this.psL = j;
        return this;
    }

    public i iy(long j) {
        this.psN = j;
        return this;
    }

    public i iz(long j) {
        this.psM = j;
        return this;
    }

    public i h(IOException iOException) {
        this.oMu = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.psO = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (psH) {
            if (psJ < 5) {
                reset();
                psJ++;
                if (psI != null) {
                    this.psP = psI;
                }
                psI = this;
            }
        }
    }

    private void reset() {
        this.psK = null;
        this.mDO = null;
        this.psL = 0L;
        this.psM = 0L;
        this.psN = 0L;
        this.oMu = null;
        this.psO = null;
    }
}
