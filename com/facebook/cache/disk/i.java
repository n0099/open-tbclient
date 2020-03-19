package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lJH = new Object();
    private static i lJI;
    private static int lJJ;
    private String jyy;
    private com.facebook.cache.common.b lJK;
    private long lJL;
    private long lJM;
    private long lJN;
    private IOException lJO;
    private CacheEventListener.EvictionReason lJP;
    private i lJQ;

    @ReturnsOwnership
    public static i dkW() {
        synchronized (lJH) {
            if (lJI != null) {
                i iVar = lJI;
                lJI = iVar.lJQ;
                iVar.lJQ = null;
                lJJ--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lJK = bVar;
        return this;
    }

    public i OP(String str) {
        this.jyy = str;
        return this;
    }

    public i eW(long j) {
        this.lJL = j;
        return this;
    }

    public i eX(long j) {
        this.lJN = j;
        return this;
    }

    public i eY(long j) {
        this.lJM = j;
        return this;
    }

    public i b(IOException iOException) {
        this.lJO = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lJP = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lJH) {
            if (lJJ < 5) {
                reset();
                lJJ++;
                if (lJI != null) {
                    this.lJQ = lJI;
                }
                lJI = this;
            }
        }
    }

    private void reset() {
        this.lJK = null;
        this.jyy = null;
        this.lJL = 0L;
        this.lJM = 0L;
        this.lJN = 0L;
        this.lJO = null;
        this.lJP = null;
    }
}
