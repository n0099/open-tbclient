package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes11.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lDE = new Object();
    private static i lDF;
    private static int lDG;
    private String jso;
    private com.facebook.cache.common.b lDH;
    private long lDI;
    private long lDJ;
    private long lDK;
    private IOException lDL;
    private CacheEventListener.EvictionReason lDM;
    private i lDN;

    @ReturnsOwnership
    public static i dig() {
        synchronized (lDE) {
            if (lDF != null) {
                i iVar = lDF;
                lDF = iVar.lDN;
                iVar.lDN = null;
                lDG--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lDH = bVar;
        return this;
    }

    public i Or(String str) {
        this.jso = str;
        return this;
    }

    public i eS(long j) {
        this.lDI = j;
        return this;
    }

    public i eT(long j) {
        this.lDK = j;
        return this;
    }

    public i eU(long j) {
        this.lDJ = j;
        return this;
    }

    public i b(IOException iOException) {
        this.lDL = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lDM = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lDE) {
            if (lDG < 5) {
                reset();
                lDG++;
                if (lDF != null) {
                    this.lDN = lDF;
                }
                lDF = this;
            }
        }
    }

    private void reset() {
        this.lDH = null;
        this.jso = null;
        this.lDI = 0L;
        this.lDJ = 0L;
        this.lDK = 0L;
        this.lDL = null;
        this.lDM = null;
    }
}
