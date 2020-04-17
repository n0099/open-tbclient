package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger lRu = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.lRu.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.lRu.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aH(result);
                }
            } catch (Exception e) {
                this.lRu.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.lRu.compareAndSet(0, 2)) {
            dmV();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dmV() {
    }

    protected void aH(T t) {
    }
}
