package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes12.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object oBo = new Object();
    private static i oBp;
    private static int oBq;
    private String mea;
    private com.facebook.cache.common.b oBr;
    private long oBs;
    private long oBt;
    private long oBu;
    private CacheEventListener.EvictionReason oBv;
    private i oBw;
    private IOException ogF;

    @ReturnsOwnership
    public static i ege() {
        synchronized (oBo) {
            if (oBp != null) {
                i iVar = oBp;
                oBp = iVar.oBw;
                iVar.oBw = null;
                oBq--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.oBr = bVar;
        return this;
    }

    public i Xt(String str) {
        this.mea = str;
        return this;
    }

    public i hf(long j) {
        this.oBs = j;
        return this;
    }

    public i hg(long j) {
        this.oBu = j;
        return this;
    }

    public i hh(long j) {
        this.oBt = j;
        return this;
    }

    public i e(IOException iOException) {
        this.ogF = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.oBv = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (oBo) {
            if (oBq < 5) {
                reset();
                oBq++;
                if (oBp != null) {
                    this.oBw = oBp;
                }
                oBp = this;
            }
        }
    }

    private void reset() {
        this.oBr = null;
        this.mea = null;
        this.oBs = 0L;
        this.oBt = 0L;
        this.oBu = 0L;
        this.ogF = null;
        this.oBv = null;
    }
}
