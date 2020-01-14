package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes12.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lHh = new Object();
    private static i lHi;
    private static int lHj;
    private String jvV;
    private com.facebook.cache.common.b lHk;
    private long lHl;
    private long lHm;
    private long lHn;
    private IOException lHo;
    private CacheEventListener.EvictionReason lHp;
    private i lHq;

    @ReturnsOwnership
    public static i djj() {
        synchronized (lHh) {
            if (lHi != null) {
                i iVar = lHi;
                lHi = iVar.lHq;
                iVar.lHq = null;
                lHj--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lHk = bVar;
        return this;
    }

    public i OB(String str) {
        this.jvV = str;
        return this;
    }

    public i eX(long j) {
        this.lHl = j;
        return this;
    }

    public i eY(long j) {
        this.lHn = j;
        return this;
    }

    public i eZ(long j) {
        this.lHm = j;
        return this;
    }

    public i b(IOException iOException) {
        this.lHo = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lHp = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lHh) {
            if (lHj < 5) {
                reset();
                lHj++;
                if (lHi != null) {
                    this.lHq = lHi;
                }
                lHi = this;
            }
        }
    }

    private void reset() {
        this.lHk = null;
        this.jvV = null;
        this.lHl = 0L;
        this.lHm = 0L;
        this.lHn = 0L;
        this.lHo = null;
        this.lHp = null;
    }
}
