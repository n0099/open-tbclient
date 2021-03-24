package f.a.x.h;

import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
/* loaded from: classes7.dex */
public interface a<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void innerError(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th);

    void innerNext(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t);
}
