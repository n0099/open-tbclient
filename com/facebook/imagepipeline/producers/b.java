package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public abstract class b<T> implements k<T> {
    private boolean lQA = false;

    protected abstract void C(Throwable th);

    protected abstract void dnL();

    protected abstract void f(T t, int i);

    public static boolean Iv(int i) {
        return (i & 1) == 1;
    }

    public static boolean Iw(int i) {
        return !Iv(i);
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

    public static int vb(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void g(@Nullable T t, int i) {
        if (!this.lQA) {
            this.lQA = Iv(i);
            try {
                f(t, i);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void D(Throwable th) {
        if (!this.lQA) {
            this.lQA = true;
            try {
                C(th);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dim() {
        if (!this.lQA) {
            this.lQA = true;
            try {
                dnL();
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aM(float f) {
        if (!this.lQA) {
            try {
                bt(f);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    protected void bt(float f) {
    }

    protected void m(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
