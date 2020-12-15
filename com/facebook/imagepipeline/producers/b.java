package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public abstract class b<T> implements k<T> {
    private boolean poA = false;

    protected abstract void D(Throwable th);

    protected abstract void evk();

    protected abstract void g(T t, int i);

    public static boolean Rh(int i) {
        return (i & 1) == 1;
    }

    public static boolean Ri(int i) {
        return !Rh(i);
    }

    public static int ee(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean ef(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean eg(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int AW(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.poA) {
            this.poA = Rh(i);
            try {
                g(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.poA) {
            this.poA = true;
            try {
                D(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void epN() {
        if (!this.poA) {
            this.poA = true;
            try {
                evk();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aV(float f) {
        if (!this.poA) {
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
