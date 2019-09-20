package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object kcu = new Object();
    private static i kcv;
    private static int kcw;
    private String iAK;
    private long kcA;
    private IOException kcB;
    private CacheEventListener.EvictionReason kcC;
    private i kcD;
    private com.facebook.cache.common.b kcx;
    private long kcy;
    private long kcz;

    public static i cFF() {
        synchronized (kcu) {
            if (kcv != null) {
                i iVar = kcv;
                kcv = iVar.kcD;
                iVar.kcD = null;
                kcw--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.kcx = bVar;
        return this;
    }

    public i If(String str) {
        this.iAK = str;
        return this;
    }

    public i eL(long j) {
        this.kcy = j;
        return this;
    }

    public i eM(long j) {
        this.kcA = j;
        return this;
    }

    public i eN(long j) {
        this.kcz = j;
        return this;
    }

    public i a(IOException iOException) {
        this.kcB = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.kcC = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (kcu) {
            if (kcw < 5) {
                reset();
                kcw++;
                if (kcv != null) {
                    this.kcD = kcv;
                }
                kcv = this;
            }
        }
    }

    private void reset() {
        this.kcx = null;
        this.iAK = null;
        this.kcy = 0L;
        this.kcz = 0L;
        this.kcA = 0L;
        this.kcB = null;
        this.kcC = null;
    }
}
