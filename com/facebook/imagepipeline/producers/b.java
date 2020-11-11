package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public abstract class b<T> implements k<T> {
    private boolean oYd = false;

    protected abstract void D(Throwable th);

    protected abstract void epG();

    protected abstract void g(T t, int i);

    public static boolean PI(int i) {
        return (i & 1) == 1;
    }

    public static boolean PJ(int i) {
        return !PI(i);
    }

    public static int dY(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dZ(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean ea(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int Ao(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.oYd) {
            this.oYd = PI(i);
            try {
                g(t, i);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void E(Throwable th) {
        if (!this.oYd) {
            this.oYd = true;
            try {
                D(th);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void ejZ() {
        if (!this.oYd) {
            this.oYd = true;
            try {
                epG();
            } catch (Exception e) {
                C(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void aN(float f) {
        if (!this.oYd) {
            try {
                br(f);
            } catch (Exception e) {
                C(e);
            }
        }
    }

    protected void br(float f) {
    }

    protected void C(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
