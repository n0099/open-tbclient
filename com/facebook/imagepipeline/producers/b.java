package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean kki = false;

    protected abstract void A(Throwable th);

    protected abstract void cHz();

    protected abstract void e(T t, boolean z);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void f(@Nullable T t, boolean z) {
        if (!this.kki) {
            this.kki = z;
            try {
                e(t, z);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void B(Throwable th) {
        if (!this.kki) {
            this.kki = true;
            try {
                A(th);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void cCF() {
        if (!this.kki) {
            this.kki = true;
            try {
                cHz();
            } catch (Exception e) {
                m(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void av(float f) {
        if (!this.kki) {
            try {
                aJ(f);
            } catch (Exception e) {
                m(e);
            }
        }
    }

    protected void aJ(float f) {
    }

    protected void m(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
