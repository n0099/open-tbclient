package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public abstract class b<T> implements k<T> {
    private boolean nXs = false;

    protected abstract void D(Throwable th);

    protected abstract void ebR();

    protected abstract void g(T t, int i);

    public static boolean Nw(int i) {
        return (i & 1) == 1;
    }

    public static boolean Nx(int i) {
        return !Nw(i);
    }

    public static int dM(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dN(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dO(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int yV(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.nXs) {
            this.nXs = Nw(i);
            try {
                g(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.nXs) {
            this.nXs = true;
            try {
                D(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dWm() {
        if (!this.nXs) {
            this.nXs = true;
            try {
                ebR();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aJ(float f) {
        if (!this.nXs) {
            try {
                aY(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void aY(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
