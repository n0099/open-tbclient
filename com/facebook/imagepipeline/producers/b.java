package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public abstract class b<T> implements k<T> {
    private boolean meI = false;

    protected abstract void F(Throwable th);

    protected abstract void dsB();

    protected abstract void g(T t, int i);

    public static boolean Hr(int i) {
        return (i & 1) == 1;
    }

    public static boolean Hs(int i) {
        return !Hr(i);
    }

    public static int dk(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static boolean dl(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean dm(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int vL(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void h(@Nullable T t, int i) {
        if (!this.meI) {
            this.meI = Hr(i);
            try {
                g(t, i);
            } catch (Exception e) {
                q(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void G(Throwable th) {
        if (!this.meI) {
            this.meI = true;
            try {
                F(th);
            } catch (Exception e) {
                q(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void dmT() {
        if (!this.meI) {
            this.meI = true;
            try {
                dsB();
            } catch (Exception e) {
                q(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.k
    public synchronized void au(float f) {
        if (!this.meI) {
            try {
                aI(f);
            } catch (Exception e) {
                q(e);
            }
        }
    }

    protected void aI(float f) {
    }

    protected void q(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
