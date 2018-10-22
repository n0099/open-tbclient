package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object hWw = new Object();
    private static i hWx;
    private static int hWy;
    private String hVN;
    private long hWA;
    private long hWB;
    private long hWC;
    private IOException hWD;
    private CacheEventListener.EvictionReason hWE;
    private i hWF;
    private com.facebook.cache.common.b hWz;

    public static i bRu() {
        synchronized (hWw) {
            if (hWx != null) {
                i iVar = hWx;
                hWx = iVar.hWF;
                iVar.hWF = null;
                hWy--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.hWz = bVar;
        return this;
    }

    public i yt(String str) {
        this.hVN = str;
        return this;
    }

    public i dq(long j) {
        this.hWA = j;
        return this;
    }

    public i dr(long j) {
        this.hWC = j;
        return this;
    }

    public i ds(long j) {
        this.hWB = j;
        return this;
    }

    public i a(IOException iOException) {
        this.hWD = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.hWE = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (hWw) {
            if (hWy < 5) {
                reset();
                hWy++;
                if (hWx != null) {
                    this.hWF = hWx;
                }
                hWx = this;
            }
        }
    }

    private void reset() {
        this.hWz = null;
        this.hVN = null;
        this.hWA = 0L;
        this.hWB = 0L;
        this.hWC = 0L;
        this.hWD = null;
        this.hWE = null;
    }
}
