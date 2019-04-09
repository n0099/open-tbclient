package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jyT = new Object();
    private static i jyU;
    private static int jyV;
    private com.facebook.cache.common.b jyW;
    private long jyX;
    private long jyY;
    private long jyZ;
    private String jyl;
    private IOException jza;
    private CacheEventListener.EvictionReason jzb;
    private i jzc;

    public static i ctx() {
        synchronized (jyT) {
            if (jyU != null) {
                i iVar = jyU;
                jyU = iVar.jzc;
                iVar.jzc = null;
                jyV--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jyW = bVar;
        return this;
    }

    public i Fn(String str) {
        this.jyl = str;
        return this;
    }

    public i eb(long j) {
        this.jyX = j;
        return this;
    }

    public i ec(long j) {
        this.jyZ = j;
        return this;
    }

    public i ed(long j) {
        this.jyY = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jza = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jzb = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jyT) {
            if (jyV < 5) {
                reset();
                jyV++;
                if (jyU != null) {
                    this.jzc = jyU;
                }
                jyU = this;
            }
        }
    }

    private void reset() {
        this.jyW = null;
        this.jyl = null;
        this.jyX = 0L;
        this.jyY = 0L;
        this.jyZ = 0L;
        this.jza = null;
        this.jzb = null;
    }
}
