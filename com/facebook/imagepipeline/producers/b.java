package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public abstract class b<T> implements k<T> {
    private boolean pNU = false;

    protected abstract void B(Throwable th);

    protected abstract void e(T t, int i);

    protected abstract void eyn();

    public static boolean Qo(int i) {
        return (i & 1) == 1;
    }

    public static boolean Qp(int i) {
        return !Qo(i);
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

    public static int Br(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void f(@Nullable T t, int i) {
        if (!this.pNU) {
            this.pNU = Qo(i);
            try {
                e(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void C(Throwable th) {
        if (!this.pNU) {
            this.pNU = true;
            try {
                B(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void esM() {
        if (!this.pNU) {
            this.pNU = true;
            try {
                eyn();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void be(float f) {
        if (!this.pNU) {
            try {
                bR(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void bR(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
