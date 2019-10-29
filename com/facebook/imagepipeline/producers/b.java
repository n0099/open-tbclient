package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean kkZ = false;

    protected abstract void cHB();

    protected abstract void e(T t, boolean z);

    protected abstract void z(Throwable th);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void f(@Nullable T t, boolean z) {
        if (!this.kkZ) {
            this.kkZ = z;
            try {
                e(t, z);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void A(Throwable th) {
        if (!this.kkZ) {
            this.kkZ = true;
            try {
                z(th);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void cCH() {
        if (!this.kkZ) {
            this.kkZ = true;
            try {
                cHB();
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void av(float f) {
        if (!this.kkZ) {
            try {
                aJ(f);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    protected void aJ(float f) {
    }

    protected void n(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
