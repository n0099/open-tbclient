package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public abstract class b<T> implements k<T> {
    private boolean pLP = false;

    protected abstract void B(Throwable th);

    protected abstract void eye();

    protected abstract void f(T t, int i);

    public static boolean Qk(int i) {
        return (i & 1) == 1;
    }

    public static boolean Ql(int i) {
        return !Qk(i);
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

    public static int Bt(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void g(@Nullable T t, int i) {
        if (!this.pLP) {
            this.pLP = Qk(i);
            try {
                f(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void C(Throwable th) {
        if (!this.pLP) {
            this.pLP = true;
            try {
                B(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void esD() {
        if (!this.pLP) {
            this.pLP = true;
            try {
                eye();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void ba(float f) {
        if (!this.pLP) {
            try {
                bN(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void bN(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", (Throwable) exc);
    }
}
