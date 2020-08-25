package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public abstract class b<T> implements k<T> {
    private boolean nxM = false;

    protected abstract void D(Throwable th);

    protected abstract void dTZ();

    protected abstract void g(T t, int i);

    public static boolean Ml(int i) {
        return (i & 1) == 1;
    }

    public static boolean Mm(int i) {
        return !Ml(i);
    }

    public static int dI(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dJ(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dK(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int yd(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.nxM) {
            this.nxM = Ml(i);
            try {
                g(t, i);
            } catch (Exception e) {
                B(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.nxM) {
            this.nxM = true;
            try {
                D(th);
            } catch (Exception e) {
                B(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dOu() {
        if (!this.nxM) {
            this.nxM = true;
            try {
                dTZ();
            } catch (Exception e) {
                B(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aD(float f) {
        if (!this.nxM) {
            try {
                aS(f);
            } catch (Exception e) {
                B(e);
            }
        }
    }

    protected void aS(float f) {
    }

    protected void B(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
