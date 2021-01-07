package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public abstract class b<T> implements k<T> {
    private boolean pFH = false;

    protected abstract void C(Throwable th);

    protected abstract void ezv();

    protected abstract void f(T t, int i);

    public static boolean Rv(int i) {
        return (i & 1) == 1;
    }

    public static boolean Rw(int i) {
        return !Rv(i);
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

    public static int Be(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void g(@Nullable T t, int i) {
        if (!this.pFH) {
            this.pFH = Rv(i);
            try {
                f(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void D(Throwable th) {
        if (!this.pFH) {
            this.pFH = true;
            try {
                C(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void etW() {
        if (!this.pFH) {
            this.pFH = true;
            try {
                ezv();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aX(float f) {
        if (!this.pFH) {
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
