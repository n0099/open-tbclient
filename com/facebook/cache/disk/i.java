package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes8.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object nkk = new Object();
    private static i nkl;
    private static int nkm;
    private String ltk;
    private IOException neq;
    private com.facebook.cache.common.b nkn;
    private long nko;
    private long nkp;
    private long nkq;
    private CacheEventListener.EvictionReason nkr;
    private i nks;

    @ReturnsOwnership
    public static i dOo() {
        synchronized (nkk) {
            if (nkl != null) {
                i iVar = nkl;
                nkl = iVar.nks;
                iVar.nks = null;
                nkm--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.nkn = bVar;
        return this;
    }

    public i Uq(String str) {
        this.ltk = str;
        return this;
    }

    public i gh(long j) {
        this.nko = j;
        return this;
    }

    public i gi(long j) {
        this.nkq = j;
        return this;
    }

    public i gj(long j) {
        this.nkp = j;
        return this;
    }

    public i e(IOException iOException) {
        this.neq = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.nkr = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (nkk) {
            if (nkm < 5) {
                reset();
                nkm++;
                if (nkl != null) {
                    this.nks = nkl;
                }
                nkl = this;
            }
        }
    }

    private void reset() {
        this.nkn = null;
        this.ltk = null;
        this.nko = 0L;
        this.nkp = 0L;
        this.nkq = 0L;
        this.neq = null;
        this.nkr = null;
    }
}
