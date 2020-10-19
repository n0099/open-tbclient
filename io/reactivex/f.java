package io.reactivex;
/* loaded from: classes17.dex */
public interface f<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
