package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object hYg = new Object();
    private static i hYh;
    private static int hYi;
    private String hXx;
    private com.facebook.cache.common.b hYj;
    private long hYk;
    private long hYl;
    private long hYm;
    private IOException hYn;
    private CacheEventListener.EvictionReason hYo;
    private i hYp;

    public static i bQP() {
        synchronized (hYg) {
            if (hYh != null) {
                i iVar = hYh;
                hYh = iVar.hYp;
                iVar.hYp = null;
                hYi--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.hYj = bVar;
        return this;
    }

    public i yy(String str) {
        this.hXx = str;
        return this;
    }

    public i dl(long j) {
        this.hYk = j;
        return this;
    }

    public i dm(long j) {
        this.hYm = j;
        return this;
    }

    public i dn(long j) {
        this.hYl = j;
        return this;
    }

    public i a(IOException iOException) {
        this.hYn = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.hYo = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (hYg) {
            if (hYi < 5) {
                reset();
                hYi++;
                if (hYh != null) {
                    this.hYp = hYh;
                }
                hYh = this;
            }
        }
    }

    private void reset() {
        this.hYj = null;
        this.hXx = null;
        this.hYk = 0L;
        this.hYl = 0L;
        this.hYm = 0L;
        this.hYn = null;
        this.hYo = null;
    }
}
