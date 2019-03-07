package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jzn = new Object();
    private static i jzo;
    private static int jzp;
    private String jyF;
    private com.facebook.cache.common.b jzq;
    private long jzr;
    private long jzs;
    private long jzt;
    private IOException jzu;
    private CacheEventListener.EvictionReason jzv;
    private i jzw;

    public static i ctr() {
        synchronized (jzn) {
            if (jzo != null) {
                i iVar = jzo;
                jzo = iVar.jzw;
                iVar.jzw = null;
                jzp--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jzq = bVar;
        return this;
    }

    public i Fw(String str) {
        this.jyF = str;
        return this;
    }

    public i ec(long j) {
        this.jzr = j;
        return this;
    }

    public i ed(long j) {
        this.jzt = j;
        return this;
    }

    public i ee(long j) {
        this.jzs = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jzu = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jzv = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jzn) {
            if (jzp < 5) {
                reset();
                jzp++;
                if (jzo != null) {
                    this.jzw = jzo;
                }
                jzo = this;
            }
        }
    }

    private void reset() {
        this.jzq = null;
        this.jyF = null;
        this.jzr = 0L;
        this.jzs = 0L;
        this.jzt = 0L;
        this.jzu = null;
        this.jzv = null;
    }
}
