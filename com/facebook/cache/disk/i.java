package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object mkY = new Object();
    private static i mkZ;
    private static int mla;
    private String kAt;
    private IOException mgh;
    private com.facebook.cache.common.b mlb;
    private long mlc;
    private long mld;
    private long mle;
    private CacheEventListener.EvictionReason mlf;
    private i mlg;

    @ReturnsOwnership
    public static i dug() {
        synchronized (mkY) {
            if (mkZ != null) {
                i iVar = mkZ;
                mkZ = iVar.mlg;
                iVar.mlg = null;
                mla--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.mlb = bVar;
        return this;
    }

    public i PN(String str) {
        this.kAt = str;
        return this;
    }

    public i fC(long j) {
        this.mlc = j;
        return this;
    }

    public i fD(long j) {
        this.mle = j;
        return this;
    }

    public i fE(long j) {
        this.mld = j;
        return this;
    }

    public i e(IOException iOException) {
        this.mgh = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.mlf = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (mkY) {
            if (mla < 5) {
                reset();
                mla++;
                if (mkZ != null) {
                    this.mlg = mkZ;
                }
                mkZ = this;
            }
        }
    }

    private void reset() {
        this.mlb = null;
        this.kAt = null;
        this.mlc = 0L;
        this.mld = 0L;
        this.mle = 0L;
        this.mgh = null;
        this.mlf = null;
    }
}
