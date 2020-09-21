package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes25.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements io.reactivex.disposables.b, Runnable, Callable<Object> {
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;
    static final Object PARENT_DISPOSED = new Object();
    static final Object SYNC_DISPOSED = new Object();
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();

    public ScheduledRunnable(Runnable runnable, io.reactivex.internal.disposables.a aVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, aVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, CHECK_CAST, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, SGET, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, INVOKE, INVOKE, SGET, MOVE_EXCEPTION, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, CHECK_CAST, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, SGET, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, INVOKE, INVOKE, SGET, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b A[DONT_GENERATE] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
            } finally {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        do {
            if (obj != obj2) {
                return;
            }
            if (obj == obj3) {
                return;
            }
        } while (!compareAndSet);
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != DONE) {
                if (obj == SYNC_DISPOSED) {
                    future.cancel(false);
                    return;
                } else if (obj == ASYNC_DISPOSED) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Object obj;
        while (true) {
            Object obj2 = get(1);
            if (obj2 == DONE || obj2 == SYNC_DISPOSED || obj2 == ASYNC_DISPOSED) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (compareAndSet(1, obj2, z ? ASYNC_DISPOSED : SYNC_DISPOSED)) {
                if (obj2 != null) {
                    ((Future) obj2).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == PARENT_DISPOSED || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, PARENT_DISPOSED));
        ((io.reactivex.internal.disposables.a) obj).c(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == PARENT_DISPOSED || obj == DONE;
    }
}
