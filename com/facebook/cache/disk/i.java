package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes12.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lHc = new Object();
    private static i lHd;
    private static int lHe;
    private String jvQ;
    private com.facebook.cache.common.b lHf;
    private long lHg;
    private long lHh;
    private long lHi;
    private IOException lHj;
    private CacheEventListener.EvictionReason lHk;
    private i lHl;

    @ReturnsOwnership
    public static i djh() {
        synchronized (lHc) {
            if (lHd != null) {
                i iVar = lHd;
                lHd = iVar.lHl;
                iVar.lHl = null;
                lHe--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lHf = bVar;
        return this;
    }

    public i OB(String str) {
        this.jvQ = str;
        return this;
    }

    public i eX(long j) {
        this.lHg = j;
        return this;
    }

    public i eY(long j) {
        this.lHi = j;
        return this;
    }

    public i eZ(long j) {
        this.lHh = j;
        return this;
    }

    public i b(IOException iOException) {
        this.lHj = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lHk = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lHc) {
            if (lHe < 5) {
                reset();
                lHe++;
                if (lHd != null) {
                    this.lHl = lHd;
                }
                lHd = this;
            }
        }
    }

    private void reset() {
        this.lHf = null;
        this.jvQ = null;
        this.lHg = 0L;
        this.lHh = 0L;
        this.lHi = 0L;
        this.lHj = null;
        this.lHk = null;
    }
}
