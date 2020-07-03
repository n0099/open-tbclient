package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public abstract class b<T> implements k<T> {
    private boolean mVQ = false;

    protected abstract void F(Throwable th);

    protected abstract void dEJ();

    protected abstract void g(T t, int i);

    public static boolean Jm(int i) {
        return (i & 1) == 1;
    }

    public static boolean Jn(int i) {
        return !Jm(i);
    }

    public static int dy(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dz(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dA(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int wH(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.mVQ) {
            this.mVQ = Jm(i);
            try {
                g(t, i);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void G(Throwable th) {
        if (!this.mVQ) {
            this.mVQ = true;
            try {
                F(th);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dzd() {
        if (!this.mVQ) {
            this.mVQ = true;
            try {
                dEJ();
            } catch (Exception e) {
                x(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void ay(float f) {
        if (!this.mVQ) {
            try {
                aN(f);
            } catch (Exception e) {
                x(e);
            }
        }
    }

    protected void aN(float f) {
    }

    protected void x(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
