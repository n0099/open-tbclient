package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object pyS = new Object();
    private static i pyT;
    private static int pyU;
    private String mIE;
    private IOException oSy;
    private com.facebook.cache.common.b pyV;
    private long pyW;
    private long pyX;
    private long pyY;
    private CacheEventListener.EvictionReason pyZ;
    private i pza;

    @ReturnsOwnership
    public static i esx() {
        synchronized (pyS) {
            if (pyT != null) {
                i iVar = pyT;
                pyT = iVar.pza;
                iVar.pza = null;
                pyU--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.pyV = bVar;
        return this;
    }

    public i Zt(String str) {
        this.mIE = str;
        return this;
    }

    public i iA(long j) {
        this.pyW = j;
        return this;
    }

    public i iB(long j) {
        this.pyY = j;
        return this;
    }

    public i iC(long j) {
        this.pyX = j;
        return this;
    }

    public i h(IOException iOException) {
        this.oSy = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.pyZ = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (pyS) {
            if (pyU < 5) {
                reset();
                pyU++;
                if (pyT != null) {
                    this.pza = pyT;
                }
                pyT = this;
            }
        }
    }

    private void reset() {
        this.pyV = null;
        this.mIE = null;
        this.pyW = 0L;
        this.pyX = 0L;
        this.pyY = 0L;
        this.oSy = null;
        this.pyZ = null;
    }
}
