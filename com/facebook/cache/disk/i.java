package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
/* loaded from: classes5.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object pys = new Object();
    private static i pyt;
    private static int pyu;
    private String mIm;
    private IOException oRY;
    private i pyA;
    private com.facebook.cache.common.b pyv;
    private long pyw;
    private long pyx;
    private long pyy;
    private CacheEventListener.EvictionReason pyz;

    @ReturnsOwnership
    public static i esp() {
        synchronized (pys) {
            if (pyt != null) {
                i iVar = pyt;
                pyt = iVar.pyA;
                iVar.pyA = null;
                pyu--;
                return iVar;
            }
            return new i();
        }
    }

    private i() {
    }

    public i h(com.facebook.cache.common.b bVar) {
        this.pyv = bVar;
        return this;
    }

    public i Zh(String str) {
        this.mIm = str;
        return this;
    }

    public i iA(long j) {
        this.pyw = j;
        return this;
    }

    public i iB(long j) {
        this.pyy = j;
        return this;
    }

    public i iC(long j) {
        this.pyx = j;
        return this;
    }

    public i h(IOException iOException) {
        this.oRY = iOException;
        return this;
    }

    public i a(CacheEventListener.EvictionReason evictionReason) {
        this.pyz = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (pys) {
            if (pyu < 5) {
                reset();
                pyu++;
                if (pyt != null) {
                    this.pyA = pyt;
                }
                pyt = this;
            }
        }
    }

    private void reset() {
        this.pyv = null;
        this.mIm = null;
        this.pyw = 0L;
        this.pyx = 0L;
        this.pyy = 0L;
        this.oRY = null;
        this.pyz = null;
    }
}
