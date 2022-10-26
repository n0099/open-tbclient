package org.reactivestreams;
/* loaded from: classes8.dex */
public interface Subscriber {
    void onComplete();

    void onError(Throwable th);

    void onNext(Object obj);

    void onSubscribe(Subscription subscription);
}
