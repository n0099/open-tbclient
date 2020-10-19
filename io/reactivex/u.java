package io.reactivex;
/* loaded from: classes17.dex */
public interface u<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(io.reactivex.disposables.b bVar);
}
