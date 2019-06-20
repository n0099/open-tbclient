package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean kcd = false;

    protected abstract void A(Throwable th);

    protected abstract void cGs();

    protected abstract void d(T t, boolean z);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void e(@Nullable T t, boolean z) {
        if (!this.kcd) {
            this.kcd = z;
            try {
                d(t, z);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void B(Throwable th) {
        if (!this.kcd) {
            this.kcd = true;
            try {
                A(th);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void cBz() {
        if (!this.kcd) {
            this.kcd = true;
            try {
                cGs();
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void aQ(float f) {
        if (!this.kcd) {
            try {
                be(f);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    protected void be(float f) {
    }

    protected void n(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
