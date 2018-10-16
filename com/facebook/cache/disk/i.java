package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object hWv = new Object();
    private static i hWw;
    private static int hWx;
    private String hVM;
    private long hWA;
    private long hWB;
    private IOException hWC;
    private CacheEventListener.EvictionReason hWD;
    private i hWE;
    private com.facebook.cache.common.b hWy;
    private long hWz;

    public static i bRu() {
        synchronized (hWv) {
            if (hWw != null) {
                i iVar = hWw;
                hWw = iVar.hWE;
                iVar.hWE = null;
                hWx--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.hWy = bVar;
        return this;
    }

    public i yt(String str) {
        this.hVM = str;
        return this;
    }

    public i dq(long j) {
        this.hWz = j;
        return this;
    }

    public i dr(long j) {
        this.hWB = j;
        return this;
    }

    public i ds(long j) {
        this.hWA = j;
        return this;
    }

    public i a(IOException iOException) {
        this.hWC = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.hWD = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (hWv) {
            if (hWx < 5) {
                reset();
                hWx++;
                if (hWw != null) {
                    this.hWE = hWw;
                }
                hWw = this;
            }
        }
    }

    private void reset() {
        this.hWy = null;
        this.hVM = null;
        this.hWz = 0L;
        this.hWA = 0L;
        this.hWB = 0L;
        this.hWC = null;
        this.hWD = null;
    }
}
