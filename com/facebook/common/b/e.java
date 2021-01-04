package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger psS = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.psS.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.psS.set(3);
                try {
                    onSuccess(result);
                } finally {
                    ba(result);
                }
            } catch (Exception e) {
                this.psS.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.psS.compareAndSet(0, 2)) {
            etQ();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void etQ() {
    }

    protected void ba(T t) {
    }
}
