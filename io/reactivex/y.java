package io.reactivex;
/* loaded from: classes6.dex */
public interface y<T> {
    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);

    void onSuccess(T t);
}
