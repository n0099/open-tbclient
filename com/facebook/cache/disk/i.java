package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object pod = new Object();
    private static i poe;
    private static int pof;
    private String mzf;
    private IOException oHQ;
    private com.facebook.cache.common.b pog;
    private long poh;
    private long poj;
    private long pok;
    private CacheEventListener.EvictionReason pol;
    private i pom;

    @ReturnsOwnership
    public static i epW() {
        synchronized (pod) {
            if (poe != null) {
                i iVar = poe;
                poe = iVar.pom;
                iVar.pom = null;
                pof--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.pog = bVar;
        return this;
    }

    public i Yg(String str) {
        this.mzf = str;
        return this;
    }

    public i ix(long j) {
        this.poh = j;
        return this;
    }

    public i iy(long j) {
        this.pok = j;
        return this;
    }

    public i iz(long j) {
        this.poj = j;
        return this;
    }

    public i h(IOException iOException) {
        this.oHQ = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.pol = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (pod) {
            if (pof < 5) {
                reset();
                pof++;
                if (poe != null) {
                    this.pom = poe;
                }
                poe = this;
            }
        }
    }

    private void reset() {
        this.pog = null;
        this.mzf = null;
        this.poh = 0L;
        this.poj = 0L;
        this.pok = 0L;
        this.oHQ = null;
        this.pol = null;
    }
}
