package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object poc = new Object();
    private static i pod;
    private static int poe;
    private String mzf;
    private IOException oHP;
    private com.facebook.cache.common.b pof;
    private long pog;
    private long poh;
    private long poj;
    private CacheEventListener.EvictionReason pok;
    private i pol;

    @ReturnsOwnership
    public static i epW() {
        synchronized (poc) {
            if (pod != null) {
                i iVar = pod;
                pod = iVar.pol;
                iVar.pol = null;
                poe--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.pof = bVar;
        return this;
    }

    public i Yf(String str) {
        this.mzf = str;
        return this;
    }

    public i ix(long j) {
        this.pog = j;
        return this;
    }

    public i iy(long j) {
        this.poj = j;
        return this;
    }

    public i iz(long j) {
        this.poh = j;
        return this;
    }

    public i h(IOException iOException) {
        this.oHP = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.pok = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (poc) {
            if (poe < 5) {
                reset();
                poe++;
                if (pod != null) {
                    this.pol = pod;
                }
                pod = this;
            }
        }
    }

    private void reset() {
        this.pof = null;
        this.mzf = null;
        this.pog = 0L;
        this.poh = 0L;
        this.poj = 0L;
        this.oHP = null;
        this.pok = null;
    }
}
