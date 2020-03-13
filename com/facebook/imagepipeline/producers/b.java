package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public abstract class b<T> implements k<T> {
    private boolean lVn = false;

    protected abstract void B(Throwable th);

    protected abstract void dqi();

    protected abstract void f(T t, int i);

    public static boolean IJ(int i) {
        return (i & 1) == 1;
    }

    public static boolean IK(int i) {
        return !IJ(i);
    }

    public static int dz(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dA(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dB(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int vr(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void g(@Nullable T t, int i) {
        if (!this.lVn) {
            this.lVn = IJ(i);
            try {
                f(t, i);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void C(Throwable th) {
        if (!this.lVn) {
            this.lVn = true;
            try {
                B(th);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dkF() {
        if (!this.lVn) {
            this.lVn = true;
            try {
                dqi();
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aK(float f) {
        if (!this.lVn) {
            try {
                bs(f);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    protected void bs(float f) {
    }

    protected void m(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
