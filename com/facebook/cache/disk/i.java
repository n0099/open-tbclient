package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jyS = new Object();
    private static i jyT;
    private static int jyU;
    private com.facebook.cache.common.b jyV;
    private long jyW;
    private long jyX;
    private long jyY;
    private IOException jyZ;
    private String jyk;
    private CacheEventListener.EvictionReason jza;
    private i jzb;

    public static i ctx() {
        synchronized (jyS) {
            if (jyT != null) {
                i iVar = jyT;
                jyT = iVar.jzb;
                iVar.jzb = null;
                jyU--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jyV = bVar;
        return this;
    }

    public i Fn(String str) {
        this.jyk = str;
        return this;
    }

    public i eb(long j) {
        this.jyW = j;
        return this;
    }

    public i ec(long j) {
        this.jyY = j;
        return this;
    }

    public i ed(long j) {
        this.jyX = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jyZ = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jza = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jyS) {
            if (jyU < 5) {
                reset();
                jyU++;
                if (jyT != null) {
                    this.jzb = jyT;
                }
                jyT = this;
            }
        }
    }

    private void reset() {
        this.jyV = null;
        this.jyk = null;
        this.jyW = 0L;
        this.jyX = 0L;
        this.jyY = 0L;
        this.jyZ = null;
        this.jza = null;
    }
}
