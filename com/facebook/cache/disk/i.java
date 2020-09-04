package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes8.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object nkC = new Object();
    private static i nkD;
    private static int nkE;
    private String ltw;
    private IOException neJ;
    private com.facebook.cache.common.b nkF;
    private long nkG;
    private long nkH;
    private long nkI;
    private CacheEventListener.EvictionReason nkJ;
    private i nkK;

    @ReturnsOwnership
    public static i dOx() {
        synchronized (nkC) {
            if (nkD != null) {
                i iVar = nkD;
                nkD = iVar.nkK;
                iVar.nkK = null;
                nkE--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.nkF = bVar;
        return this;
    }

    public i Uq(String str) {
        this.ltw = str;
        return this;
    }

    public i gj(long j) {
        this.nkG = j;
        return this;
    }

    public i gk(long j) {
        this.nkI = j;
        return this;
    }

    public i gl(long j) {
        this.nkH = j;
        return this;
    }

    public i e(IOException iOException) {
        this.neJ = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.nkJ = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (nkC) {
            if (nkE < 5) {
                reset();
                nkE++;
                if (nkD != null) {
                    this.nkK = nkD;
                }
                nkD = this;
            }
        }
    }

    private void reset() {
        this.nkF = null;
        this.ltw = null;
        this.nkG = 0L;
        this.nkH = 0L;
        this.nkI = 0L;
        this.neJ = null;
        this.nkJ = null;
    }
}
