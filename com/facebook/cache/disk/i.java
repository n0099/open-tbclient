package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object ijL = new Object();
    private static i ijM;
    private static int ijN;
    private com.facebook.cache.common.b ijO;
    private long ijP;
    private long ijQ;
    private long ijR;
    private IOException ijS;
    private CacheEventListener.EvictionReason ijT;
    private i ijU;
    private String ijc;

    public static i bUt() {
        synchronized (ijL) {
            if (ijM != null) {
                i iVar = ijM;
                ijM = iVar.ijU;
                iVar.ijU = null;
                ijN--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.ijO = bVar;
        return this;
    }

    public i zu(String str) {
        this.ijc = str;
        return this;
    }

    public i dx(long j) {
        this.ijP = j;
        return this;
    }

    public i dy(long j) {
        this.ijR = j;
        return this;
    }

    public i dz(long j) {
        this.ijQ = j;
        return this;
    }

    public i a(IOException iOException) {
        this.ijS = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.ijT = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (ijL) {
            if (ijN < 5) {
                reset();
                ijN++;
                if (ijM != null) {
                    this.ijU = ijM;
                }
                ijM = this;
            }
        }
    }

    private void reset() {
        this.ijO = null;
        this.ijc = null;
        this.ijP = 0L;
        this.ijQ = 0L;
        this.ijR = 0L;
        this.ijS = null;
        this.ijT = null;
    }
}
