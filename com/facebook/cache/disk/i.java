package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object kaD = new Object();
    private static i kaE;
    private static int kaF;
    private String izh;
    private com.facebook.cache.common.b kaG;
    private long kaH;
    private long kaI;
    private long kaJ;
    private IOException kaK;
    private CacheEventListener.EvictionReason kaL;
    private i kaM;

    public static i cCD() {
        synchronized (kaD) {
            if (kaE != null) {
                i iVar = kaE;
                kaE = iVar.kaM;
                iVar.kaM = null;
                kaF--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.kaG = bVar;
        return this;
    }

    public i Gw(String str) {
        this.izh = str;
        return this;
    }

    public i ef(long j) {
        this.kaH = j;
        return this;
    }

    public i eg(long j) {
        this.kaJ = j;
        return this;
    }

    public i eh(long j) {
        this.kaI = j;
        return this;
    }

    public i a(IOException iOException) {
        this.kaK = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.kaL = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (kaD) {
            if (kaF < 5) {
                reset();
                kaF++;
                if (kaE != null) {
                    this.kaM = kaE;
                }
                kaE = this;
            }
        }
    }

    private void reset() {
        this.kaG = null;
        this.izh = null;
        this.kaH = 0L;
        this.kaI = 0L;
        this.kaJ = 0L;
        this.kaK = null;
        this.kaL = null;
    }
}
