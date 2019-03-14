package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static int jzA;
    private static final Object jzy = new Object();
    private static i jzz;
    private String jyQ;
    private com.facebook.cache.common.b jzB;
    private long jzC;
    private long jzD;
    private long jzE;
    private IOException jzF;
    private CacheEventListener.EvictionReason jzG;
    private i jzH;

    public static i ctE() {
        synchronized (jzy) {
            if (jzz != null) {
                i iVar = jzz;
                jzz = iVar.jzH;
                iVar.jzH = null;
                jzA--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.jzB = bVar;
        return this;
    }

    public i Fx(String str) {
        this.jyQ = str;
        return this;
    }

    public i ec(long j) {
        this.jzC = j;
        return this;
    }

    public i ed(long j) {
        this.jzE = j;
        return this;
    }

    public i ee(long j) {
        this.jzD = j;
        return this;
    }

    public i a(IOException iOException) {
        this.jzF = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.jzG = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jzy) {
            if (jzA < 5) {
                reset();
                jzA++;
                if (jzz != null) {
                    this.jzH = jzz;
                }
                jzz = this;
            }
        }
    }

    private void reset() {
        this.jzB = null;
        this.jyQ = null;
        this.jzC = 0L;
        this.jzD = 0L;
        this.jzE = 0L;
        this.jzF = null;
        this.jzG = null;
    }
}
