package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes7.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object pbt = new Object();
    private static i pbu;
    private static int pbv;
    private String myw;
    private IOException oGj;
    private CacheEventListener.EvictionReason pbA;
    private i pbB;
    private com.facebook.cache.common.b pbw;
    private long pbx;
    private long pby;
    private long pbz;

    @ReturnsOwnership
    public static i epG() {
        synchronized (pbt) {
            if (pbu != null) {
                i iVar = pbu;
                pbu = iVar.pbB;
                iVar.pbB = null;
                pbv--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.pbw = bVar;
        return this;
    }

    public i Zd(String str) {
        this.myw = str;
        return this;
    }

    public i ij(long j) {
        this.pbx = j;
        return this;
    }

    public i ik(long j) {
        this.pbz = j;
        return this;
    }

    public i il(long j) {
        this.pby = j;
        return this;
    }

    public i e(IOException iOException) {
        this.oGj = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.pbA = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (pbt) {
            if (pbv < 5) {
                reset();
                pbv++;
                if (pbu != null) {
                    this.pbB = pbu;
                }
                pbu = this;
            }
        }
    }

    private void reset() {
        this.pbw = null;
        this.myw = null;
        this.pbx = 0L;
        this.pby = 0L;
        this.pbz = 0L;
        this.oGj = null;
        this.pbA = null;
    }
}
