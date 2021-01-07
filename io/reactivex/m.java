package io.reactivex;
/* loaded from: classes5.dex */
public interface m<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);

    void onSuccess(T t);
}
