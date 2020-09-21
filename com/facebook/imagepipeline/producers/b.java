package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes25.dex */
public abstract class b<T> implements k<T> {
    private boolean nIb = false;

    protected abstract void D(Throwable th);

    protected abstract void dYg();

    protected abstract void g(T t, int i);

    public static boolean MQ(int i) {
        return (i & 1) == 1;
    }

    public static boolean MR(int i) {
        return !MQ(i);
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

    public static int yo(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.nIb) {
            this.nIb = MQ(i);
            try {
                g(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.nIb) {
            this.nIb = true;
            try {
                D(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dSB() {
        if (!this.nIb) {
            this.nIb = true;
            try {
                dYg();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aD(float f) {
        if (!this.nIb) {
            try {
                aS(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void aS(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
