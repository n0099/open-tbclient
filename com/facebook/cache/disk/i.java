package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes12.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object nuC = new Object();
    private static i nuD;
    private static int nuE;
    private String lCn;
    private IOException noJ;
    private com.facebook.cache.common.b nuF;
    private long nuG;
    private long nuH;
    private long nuI;
    private CacheEventListener.EvictionReason nuJ;
    private i nuK;

    @ReturnsOwnership
    public static i dSv() {
        synchronized (nuC) {
            if (nuD != null) {
                i iVar = nuD;
                nuD = iVar.nuK;
                iVar.nuK = null;
                nuE--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.nuF = bVar;
        return this;
    }

    public i US(String str) {
        this.lCn = str;
        return this;
    }

    public i gx(long j) {
        this.nuG = j;
        return this;
    }

    public i gy(long j) {
        this.nuI = j;
        return this;
    }

    public i gz(long j) {
        this.nuH = j;
        return this;
    }

    public i e(IOException iOException) {
        this.noJ = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.nuJ = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (nuC) {
            if (nuE < 5) {
                reset();
                nuE++;
                if (nuD != null) {
                    this.nuK = nuD;
                }
                nuD = this;
            }
        }
    }

    private void reset() {
        this.nuF = null;
        this.lCn = null;
        this.nuG = 0L;
        this.nuH = 0L;
        this.nuI = 0L;
        this.noJ = null;
        this.nuJ = null;
    }
}
