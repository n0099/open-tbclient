package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.u;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class BlockingObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // io.reactivex.u
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}
