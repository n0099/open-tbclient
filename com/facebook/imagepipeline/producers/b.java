package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes10.dex */
public abstract class b<T> implements k<T> {
    private boolean lUo = false;

    protected abstract void C(Throwable th);

    protected abstract void doR();

    protected abstract void f(T t, int i);

    public static boolean IE(int i) {
        return (i & 1) == 1;
    }

    public static boolean IF(int i) {
        return !IE(i);
    }

    public static int dw(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dx(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dy(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int vn(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void g(@Nullable T t, int i) {
        if (!this.lUo) {
            this.lUo = IE(i);
            try {
                f(t, i);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void D(Throwable th) {
        if (!this.lUo) {
            this.lUo = true;
            try {
                C(th);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void djn() {
        if (!this.lUo) {
            this.lUo = true;
            try {
                doR();
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aL(float f) {
        if (!this.lUo) {
            try {
                bt(f);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    protected void bt(float f) {
    }

    protected void m(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
