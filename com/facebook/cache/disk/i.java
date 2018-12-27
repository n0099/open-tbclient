package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object iiD = new Object();
    private static i iiE;
    private static int iiF;
    private String ihU;
    private com.facebook.cache.common.b iiG;
    private long iiH;
    private long iiI;
    private long iiJ;
    private IOException iiK;
    private CacheEventListener.EvictionReason iiL;
    private i iiM;

    public static i bTL() {
        synchronized (iiD) {
            if (iiE != null) {
                i iVar = iiE;
                iiE = iVar.iiM;
                iVar.iiM = null;
                iiF--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.iiG = bVar;
        return this;
    }

    public i ze(String str) {
        this.ihU = str;
        return this;
    }

    public i dx(long j) {
        this.iiH = j;
        return this;
    }

    public i dy(long j) {
        this.iiJ = j;
        return this;
    }

    public i dz(long j) {
        this.iiI = j;
        return this;
    }

    public i a(IOException iOException) {
        this.iiK = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.iiL = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (iiD) {
            if (iiF < 5) {
                reset();
                iiF++;
                if (iiE != null) {
                    this.iiM = iiE;
                }
                iiE = this;
            }
        }
    }

    private void reset() {
        this.iiG = null;
        this.ihU = null;
        this.iiH = 0L;
        this.iiI = 0L;
        this.iiJ = 0L;
        this.iiK = null;
        this.iiL = null;
    }
}
