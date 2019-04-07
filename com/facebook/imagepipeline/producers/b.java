package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class b<T> implements j<T> {
    private boolean jJl = false;

    protected abstract void B(Throwable th);

    protected abstract void cyv();

    protected abstract void d(T t, boolean z);

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void e(@Nullable T t, boolean z) {
        if (!this.jJl) {
            this.jJl = z;
            try {
                d(t, z);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void C(Throwable th) {
        if (!this.jJl) {
            this.jJl = true;
            try {
                B(th);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void ctB() {
        if (!this.jJl) {
            this.jJl = true;
            try {
                cyv();
            } catch (Exception e) {
                n(e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.j
    public synchronized void aM(float f) {
        if (!this.jJl) {
            try {
                ba(f);
            } catch (Exception e) {
                n(e);
            }
        }
    }

    protected void ba(float f) {
    }

    protected void n(Exception exc) {
        com.facebook.common.c.a.c(getClass(), "unhandled exception", exc);
    }
}
