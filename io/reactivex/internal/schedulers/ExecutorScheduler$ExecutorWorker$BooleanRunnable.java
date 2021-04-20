package io.reactivex.internal.schedulers;

import f.b.t.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ExecutorScheduler$ExecutorWorker$BooleanRunnable extends AtomicBoolean implements Runnable, b {
    public static final long serialVersionUID = -2421395018820541164L;
    public final Runnable actual;

    public ExecutorScheduler$ExecutorWorker$BooleanRunnable(Runnable runnable) {
        this.actual = runnable;
    }

    @Override // f.b.t.b
    public void dispose() {
        lazySet(true);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get()) {
            return;
        }
        try {
            this.actual.run();
        } finally {
            lazySet(true);
        }
    }
}
