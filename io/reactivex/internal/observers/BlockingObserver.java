package io.reactivex.internal.observers;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class BlockingObserver<T> extends AtomicReference<b> implements o<T>, b {
    public static final Object TERMINATED = new Object();
    public static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // f.b.t.b
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.o
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
