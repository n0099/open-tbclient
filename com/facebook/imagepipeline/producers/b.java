package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean kkq = false;

    protected abstract void A(Throwable th);

    protected abstract void cJQ();

    protected abstract void d(T t, boolean z);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void e(@Nullable T t, boolean z) {
        if (!this.kkq) {
            this.kkq = z;
            try {
                d(t, z);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void B(Throwable th) {
        if (!this.kkq) {
            this.kkq = true;
            try {
                A(th);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void cEV() {
        if (!this.kkq) {
            this.kkq = true;
            try {
                cJQ();
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void aR(float f) {
        if (!this.kkq) {
            try {
                bf(f);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    protected void bf(float f) {
    }

    protected void n(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
