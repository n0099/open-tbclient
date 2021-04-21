package io.reactivex.internal.schedulers;

import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ExecutorScheduler$DelayedRunnable extends AtomicReference<Runnable> implements Runnable, b {
    public static final long serialVersionUID = -4101336210206799084L;
    public final SequentialDisposable direct;
    public final SequentialDisposable timed;

    public ExecutorScheduler$DelayedRunnable(Runnable runnable) {
        super(runnable);
        this.timed = new SequentialDisposable();
        this.direct = new SequentialDisposable();
    }

    @Override // f.b.t.b
    public void dispose() {
        if (getAndSet(null) != null) {
            this.timed.dispose();
            this.direct.dispose();
        }
    }

    public Runnable getWrappedRunnable() {
        Runnable runnable = get();
        return runnable != null ? runnable : Functions.f69179a;
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = get();
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                lazySet(null);
                this.timed.lazySet(DisposableHelper.DISPOSED);
                this.direct.lazySet(DisposableHelper.DISPOSED);
            }
        }
    }
}
