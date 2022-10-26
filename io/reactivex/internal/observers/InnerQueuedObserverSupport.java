package io.reactivex.internal.observers;
/* loaded from: classes8.dex */
public interface InnerQueuedObserverSupport {
    void drain();

    void innerComplete(InnerQueuedObserver innerQueuedObserver);

    void innerError(InnerQueuedObserver innerQueuedObserver, Throwable th);

    void innerNext(InnerQueuedObserver innerQueuedObserver, Object obj);
}
