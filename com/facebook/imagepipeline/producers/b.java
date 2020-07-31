package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public abstract class b<T> implements k<T> {
    private boolean ndU = false;

    protected abstract void E(Throwable th);

    protected abstract void dHZ();

    protected abstract void g(T t, int i);

    public static boolean JH(int i) {
        return (i & 1) == 1;
    }

    public static boolean JI(int i) {
        return !JH(i);
    }

    public static int dA(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dB(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dC(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int xm(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.ndU) {
            this.ndU = JH(i);
            try {
                g(t, i);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void F(Throwable th) {
        if (!this.ndU) {
            this.ndU = true;
            try {
                E(th);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dCt() {
        if (!this.ndU) {
            this.ndU = true;
            try {
                dHZ();
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void ax(float f) {
        if (!this.ndU) {
            try {
                aM(f);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    protected void aM(float f) {
    }

    protected void x(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
