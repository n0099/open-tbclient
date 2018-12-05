package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
/* loaded from: classes2.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object ift = new Object();
    private static i ifu;
    private static int ifv;
    private String ieK;
    private IOException ifA;
    private CacheEventListener.EvictionReason ifB;
    private i ifC;
    private com.facebook.cache.common.b ifw;
    private long ifx;
    private long ify;
    private long ifz;

    public static i bSV() {
        synchronized (ift) {
            if (ifu != null) {
                i iVar = ifu;
                ifu = iVar.ifC;
                iVar.ifC = null;
                ifv--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i g(com.facebook.cache.common.b bVar) {
        this.ifw = bVar;
        return this;
    }

    public i zb(String str) {
        this.ieK = str;
        return this;
    }

    public i ds(long j) {
        this.ifx = j;
        return this;
    }

    public i dt(long j) {
        this.ifz = j;
        return this;
    }

    public i du(long j) {
        this.ify = j;
        return this;
    }

    public i a(IOException iOException) {
        this.ifA = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.ifB = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (ift) {
            if (ifv < 5) {
                reset();
                ifv++;
                if (ifu != null) {
                    this.ifC = ifu;
                }
                ifu = this;
            }
        }
    }

    private void reset() {
        this.ifw = null;
        this.ieK = null;
        this.ifx = 0L;
        this.ify = 0L;
        this.ifz = 0L;
        this.ifA = null;
        this.ifB = null;
    }
}
