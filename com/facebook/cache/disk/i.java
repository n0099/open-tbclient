package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes6.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object psG = new Object();
    private static i psH;
    private static int psI;
    private String mDP;
    private IOException oMu;
    private com.facebook.cache.common.b psJ;
    private long psK;
    private long psL;
    private long psM;
    private CacheEventListener.EvictionReason psN;
    private i psO;

    @ReturnsOwnership
    public static i etM() {
        synchronized (psG) {
            if (psH != null) {
                i iVar = psH;
                psH = iVar.psO;
                iVar.psO = null;
                psI--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.psJ = bVar;
        return this;
    }

    public i Zo(String str) {
        this.mDP = str;
        return this;
    }

    public i ix(long j) {
        this.psK = j;
        return this;
    }

    public i iy(long j) {
        this.psM = j;
        return this;
    }

    public i iz(long j) {
        this.psL = j;
        return this;
    }

    public i h(IOException iOException) {
        this.oMu = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.psN = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (psG) {
            if (psI < 5) {
                reset();
                psI++;
                if (psH != null) {
                    this.psO = psH;
                }
                psH = this;
            }
        }
    }

    private void reset() {
        this.psJ = null;
        this.mDP = null;
        this.psK = 0L;
        this.psL = 0L;
        this.psM = 0L;
        this.oMu = null;
        this.psN = null;
    }
}
