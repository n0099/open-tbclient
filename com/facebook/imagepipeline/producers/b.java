package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public abstract class b<T> implements k<T> {
    private boolean nye = false;

    protected abstract void D(Throwable th);

    protected abstract void dUi();

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

    public static int yf(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.nye) {
            this.nye = Ml(i);
            try {
                g(t, i);
            } catch (Exception e) {
                B(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.nye) {
            this.nye = true;
            try {
                D(th);
            } catch (Exception e) {
                B(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dOD() {
        if (!this.nye) {
            this.nye = true;
            try {
                dUi();
            } catch (Exception e) {
                B(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aD(float f) {
        if (!this.nye) {
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
