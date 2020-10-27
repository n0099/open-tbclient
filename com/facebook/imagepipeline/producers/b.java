package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public abstract class b<T> implements k<T> {
    private boolean oOK = false;

    protected abstract void D(Throwable th);

    protected abstract void elP();

    protected abstract void g(T t, int i);

    public static boolean Pn(int i) {
        return (i & 1) == 1;
    }

    public static boolean Po(int i) {
        return !Pn(i);
    }

    public static int dV(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dW(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dX(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int Ad(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.oOK) {
            this.oOK = Pn(i);
            try {
                g(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.oOK) {
            this.oOK = true;
            try {
                D(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void egk() {
        if (!this.oOK) {
            this.oOK = true;
            try {
                elP();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aL(float f) {
        if (!this.oOK) {
            try {
                bp(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void bp(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
