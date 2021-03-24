package f.a.x.d;

import io.reactivex.internal.observers.InnerQueuedObserver;
/* loaded from: classes7.dex */
public interface b<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> innerQueuedObserver);

    void innerError(InnerQueuedObserver<T> innerQueuedObserver, Throwable th);

    void innerNext(InnerQueuedObserver<T> innerQueuedObserver, T t);
}
