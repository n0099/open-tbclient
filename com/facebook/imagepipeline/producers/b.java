package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean isQ = false;

    protected abstract void A(Throwable th);

    protected abstract void bYC();

    protected abstract void d(T t, boolean z);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void e(@Nullable T t, boolean z) {
        if (!this.isQ) {
            this.isQ = z;
            try {
                d(t, z);
            } catch (Exception e) {
                k(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void B(Throwable th) {
        if (!this.isQ) {
            this.isQ = true;
            try {
                A(th);
            } catch (Exception e) {
                k(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void bTP() {
        if (!this.isQ) {
            this.isQ = true;
            try {
                bYC();
            } catch (Exception e) {
                k(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void az(float f) {
        if (!this.isQ) {
            try {
                aM(f);
            } catch (Exception e) {
                k(e);
            }
        }
    }

    protected void aM(float f) {
    }

    protected void k(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
