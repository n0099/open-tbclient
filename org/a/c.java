package org.a;
/* loaded from: classes8.dex */
public interface c<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(d dVar);
}
