package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object mmi = new Object();
    private static i mmj;
    private static int mmk;
    private String kBz;
    private IOException mhr;
    private com.facebook.cache.common.b mml;
    private long mmm;
    private long mmn;
    private long mmo;
    private CacheEventListener.EvictionReason mmp;
    private i mmq;

    @ReturnsOwnership
    public static i duu() {
        synchronized (mmi) {
            if (mmj != null) {
                i iVar = mmj;
                mmj = iVar.mmq;
                iVar.mmq = null;
                mmk--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.mml = bVar;
        return this;
    }

    public i PO(String str) {
        this.kBz = str;
        return this;
    }

    public i fC(long j) {
        this.mmm = j;
        return this;
    }

    public i fD(long j) {
        this.mmo = j;
        return this;
    }

    public i fE(long j) {
        this.mmn = j;
        return this;
    }

    public i e(IOException iOException) {
        this.mhr = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.mmp = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (mmi) {
            if (mmk < 5) {
                reset();
                mmk++;
                if (mmj != null) {
                    this.mmq = mmj;
                }
                mmj = this;
            }
        }
    }

    private void reset() {
        this.mml = null;
        this.kBz = null;
        this.mmm = 0L;
        this.mmn = 0L;
        this.mmo = 0L;
        this.mhr = null;
        this.mmp = null;
    }
}
