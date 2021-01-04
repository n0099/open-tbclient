package io.reactivex;
/* loaded from: classes3.dex */
public interface m<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);

    void onSuccess(T t);
}
