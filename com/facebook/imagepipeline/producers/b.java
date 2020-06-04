package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public abstract class b<T> implements k<T> {
    private boolean mzJ = false;

    protected abstract void F(Throwable th);

    protected abstract void dAh();

    protected abstract void g(T t, int i);

    public static boolean If(int i) {
        return (i & 1) == 1;
    }

    public static boolean Ig(int i) {
        return !If(i);
    }

    public static int dp(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dq(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dr(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int wl(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.mzJ) {
            this.mzJ = If(i);
            try {
                g(t, i);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void G(Throwable th) {
        if (!this.mzJ) {
            this.mzJ = true;
            try {
                F(th);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void duA() {
        if (!this.mzJ) {
            this.mzJ = true;
            try {
                dAh();
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void at(float f) {
        if (!this.mzJ) {
            try {
                aH(f);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    protected void aH(float f) {
    }

    protected void x(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
