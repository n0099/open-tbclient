package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public abstract class b<T> implements k<T> {
    private boolean oZG = false;

    protected abstract void D(Throwable th);

    protected abstract void epE();

    protected abstract void g(T t, int i);

    public static boolean Ql(int i) {
        return (i & 1) == 1;
    }

    public static boolean Qm(int i) {
        return !Ql(i);
    }

    public static int dZ(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean ea(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean eb(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int Av(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.oZG) {
            this.oZG = Ql(i);
            try {
                g(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.oZG) {
            this.oZG = true;
            try {
                D(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void ejX() {
        if (!this.oZG) {
            this.oZG = true;
            try {
                epE();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aU(float f) {
        if (!this.oZG) {
            try {
                by(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void by(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
