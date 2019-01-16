package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object ijK = new Object();
    private static i ijL;
    private static int ijM;
    private com.facebook.cache.common.b ijN;
    private long ijO;
    private long ijP;
    private long ijQ;
    private IOException ijR;
    private CacheEventListener.EvictionReason ijS;
    private i ijT;
    private String ijb;

    public static i bUt() {
        synchronized (ijK) {
            if (ijL != null) {
                i iVar = ijL;
                ijL = iVar.ijT;
                iVar.ijT = null;
                ijM--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.ijN = bVar;
        return this;
    }

    public i zu(String str) {
        this.ijb = str;
        return this;
    }

    public i dx(long j) {
        this.ijO = j;
        return this;
    }

    public i dy(long j) {
        this.ijQ = j;
        return this;
    }

    public i dz(long j) {
        this.ijP = j;
        return this;
    }

    public i a(IOException iOException) {
        this.ijR = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.ijS = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (ijK) {
            if (ijM < 5) {
                reset();
                ijM++;
                if (ijL != null) {
                    this.ijT = ijL;
                }
                ijL = this;
            }
        }
    }

    private void reset() {
        this.ijN = null;
        this.ijb = null;
        this.ijO = 0L;
        this.ijP = 0L;
        this.ijQ = 0L;
        this.ijR = null;
        this.ijS = null;
    }
}
