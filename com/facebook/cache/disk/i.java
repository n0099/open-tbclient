package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lRg = new Object();
    private static i lRh;
    private static int lRi;
    private String kiz;
    private IOException lMS;
    private com.facebook.cache.common.b lRj;
    private long lRk;
    private long lRl;
    private long lRm;
    private CacheEventListener.EvictionReason lRn;
    private i lRo;

    @ReturnsOwnership
    public static i dmN() {
        synchronized (lRg) {
            if (lRh != null) {
                i iVar = lRh;
                lRh = iVar.lRo;
                iVar.lRo = null;
                lRi--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lRj = bVar;
        return this;
    }

    public i NZ(String str) {
        this.kiz = str;
        return this;
    }

    public i fC(long j) {
        this.lRk = j;
        return this;
    }

    public i fD(long j) {
        this.lRm = j;
        return this;
    }

    public i fE(long j) {
        this.lRl = j;
        return this;
    }

    public i d(IOException iOException) {
        this.lMS = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lRn = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lRg) {
            if (lRi < 5) {
                reset();
                lRi++;
                if (lRh != null) {
                    this.lRo = lRh;
                }
                lRh = this;
            }
        }
    }

    private void reset() {
        this.lRj = null;
        this.kiz = null;
        this.lRk = 0L;
        this.lRl = 0L;
        this.lRm = 0L;
        this.lMS = null;
        this.lRn = null;
    }
}
