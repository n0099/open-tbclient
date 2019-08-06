package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object jZX = new Object();
    private static i jZY;
    private static int jZZ;
    private String iyI;
    private com.facebook.cache.common.b kaa;
    private long kab;
    private long kac;
    private long kad;
    private IOException kae;
    private CacheEventListener.EvictionReason kaf;
    private i kag;

    public static i cER() {
        synchronized (jZX) {
            if (jZY != null) {
                i iVar = jZY;
                jZY = iVar.kag;
                iVar.kag = null;
                jZZ--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.kaa = bVar;
        return this;
    }

    public i HF(String str) {
        this.iyI = str;
        return this;
    }

    public i eI(long j) {
        this.kab = j;
        return this;
    }

    public i eJ(long j) {
        this.kad = j;
        return this;
    }

    public i eK(long j) {
        this.kac = j;
        return this;
    }

    public i a(IOException iOException) {
        this.kae = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.kaf = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (jZX) {
            if (jZZ < 5) {
                reset();
                jZZ++;
                if (jZY != null) {
                    this.kag = jZY;
                }
                jZY = this;
            }
        }
    }

    private void reset() {
        this.kaa = null;
        this.iyI = null;
        this.kab = 0L;
        this.kac = 0L;
        this.kad = 0L;
        this.kae = null;
        this.kaf = null;
    }
}
