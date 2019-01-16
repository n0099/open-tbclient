package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean itX = false;

    protected abstract void A(Throwable th);

    protected abstract void bZk();

    protected abstract void d(T t, boolean z);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void e(@Nullable T t, boolean z) {
        if (!this.itX) {
            this.itX = z;
            try {
                d(t, z);
            } catch (Exception e) {
                j(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void B(Throwable th) {
        if (!this.itX) {
            this.itX = true;
            try {
                A(th);
            } catch (Exception e) {
                j(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void bUx() {
        if (!this.itX) {
            this.itX = true;
            try {
                bZk();
            } catch (Exception e) {
                j(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void az(float f) {
        if (!this.itX) {
            try {
                aM(f);
            } catch (Exception e) {
                j(e);
            }
        }
    }

    protected void aM(float f) {
    }

    protected void j(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
