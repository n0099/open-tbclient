package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public abstract class b<T> implements k<T> {
    private boolean pEa = false;

    protected abstract void C(Throwable th);

    protected abstract void eyT();

    protected abstract void f(T t, int i);

    public static boolean Rf(int i) {
        return (i & 1) == 1;
    }

    public static boolean Rg(int i) {
        return !Rf(i);
    }

    public static int ec(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean ed(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean ee(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int Be(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void g(@Nullable T t, int i) {
        if (!this.pEa) {
            this.pEa = Rf(i);
            try {
                f(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void D(Throwable th) {
        if (!this.pEa) {
            this.pEa = true;
            try {
                C(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void etQ() {
        if (!this.pEa) {
            this.pEa = true;
            try {
                eyT();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aX(float f) {
        if (!this.pEa) {
            try {
                bK(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void bK(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", (Throwable) exc);
    }
}
