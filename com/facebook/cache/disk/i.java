package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes7.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object pbv = new Object();
    private static i pbw;
    private static int pbx;
    private String myy;
    private IOException oGl;
    private long pbA;
    private long pbB;
    private CacheEventListener.EvictionReason pbC;
    private i pbD;
    private com.facebook.cache.common.b pby;
    private long pbz;

    @ReturnsOwnership
    public static i epH() {
        synchronized (pbv) {
            if (pbw != null) {
                i iVar = pbw;
                pbw = iVar.pbD;
                iVar.pbD = null;
                pbx--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.pby = bVar;
        return this;
    }

    public i Zd(String str) {
        this.myy = str;
        return this;
    }

    public i ij(long j) {
        this.pbz = j;
        return this;
    }

    public i ik(long j) {
        this.pbB = j;
        return this;
    }

    public i il(long j) {
        this.pbA = j;
        return this;
    }

    public i e(IOException iOException) {
        this.oGl = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.pbC = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (pbv) {
            if (pbx < 5) {
                reset();
                pbx++;
                if (pbw != null) {
                    this.pbD = pbw;
                }
                pbw = this;
            }
        }
    }

    private void reset() {
        this.pby = null;
        this.myy = null;
        this.pbz = 0L;
        this.pbA = 0L;
        this.pbB = 0L;
        this.oGl = null;
        this.pbC = null;
    }
}
