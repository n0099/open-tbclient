package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean igJ = false;

    protected abstract void A(Throwable th);

    protected abstract void bWl();

    protected abstract void d(T t, boolean z);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void e(@Nullable T t, boolean z) {
        if (!this.igJ) {
            this.igJ = z;
            try {
                d(t, z);
            } catch (Exception e) {
                k(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void B(Throwable th) {
        if (!this.igJ) {
            this.igJ = true;
            try {
                A(th);
            } catch (Exception e) {
                k(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void bRy() {
        if (!this.igJ) {
            this.igJ = true;
            try {
                bWl();
            } catch (Exception e) {
                k(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void ax(float f) {
        if (!this.igJ) {
            try {
                aK(f);
            } catch (Exception e) {
                k(e);
            }
        }
    }

    protected void aK(float f) {
    }

    protected void k(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
