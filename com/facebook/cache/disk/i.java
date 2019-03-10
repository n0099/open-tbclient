package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jzG = new Object();
    private static i jzH;
    private static int jzI;
    private String jyY;
    private com.facebook.cache.common.b jzJ;
    private long jzK;
    private long jzL;
    private long jzM;
    private IOException jzN;
    private CacheEventListener.EvictionReason jzO;
    private i jzP;

    public static i ctB() {
        synchronized (jzG) {
            if (jzH != null) {
                i iVar = jzH;
                jzH = iVar.jzP;
                iVar.jzP = null;
                jzI--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jzJ = bVar;
        return this;
    }

    public i Fz(String str) {
        this.jyY = str;
        return this;
    }

    public i ec(long j) {
        this.jzK = j;
        return this;
    }

    public i ed(long j) {
        this.jzM = j;
        return this;
    }

    public i ee(long j) {
        this.jzL = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jzN = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jzO = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jzG) {
            if (jzI < 5) {
                reset();
                jzI++;
                if (jzH != null) {
                    this.jzP = jzH;
                }
                jzH = this;
            }
        }
    }

    private void reset() {
        this.jzJ = null;
        this.jyY = null;
        this.jzK = 0L;
        this.jzL = 0L;
        this.jzM = 0L;
        this.jzN = null;
        this.jzO = null;
    }
}
