package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes13.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object lIb = new Object();
    private static i lIc;
    private static int lId;
    private String jwZ;
    private com.facebook.cache.common.b lIe;
    private long lIf;
    private long lIg;
    private long lIh;
    private IOException lIi;
    private CacheEventListener.EvictionReason lIj;
    private i lIk;

    @ReturnsOwnership
    public static i dkz() {
        synchronized (lIb) {
            if (lIc != null) {
                i iVar = lIc;
                lIc = iVar.lIk;
                iVar.lIk = null;
                lId--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.lIe = bVar;
        return this;
    }

    public i OP(String str) {
        this.jwZ = str;
        return this;
    }

    public i eV(long j) {
        this.lIf = j;
        return this;
    }

    public i eW(long j) {
        this.lIh = j;
        return this;
    }

    public i eX(long j) {
        this.lIg = j;
        return this;
    }

    public i b(IOException iOException) {
        this.lIi = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.lIj = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (lIb) {
            if (lId < 5) {
                reset();
                lId++;
                if (lIc != null) {
                    this.lIk = lIc;
                }
                lIc = this;
            }
        }
    }

    private void reset() {
        this.lIe = null;
        this.jwZ = null;
        this.lIf = 0L;
        this.lIg = 0L;
        this.lIh = 0L;
        this.lIi = null;
        this.lIj = null;
    }
}
