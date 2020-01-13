package io.reactivex;
/* loaded from: classes5.dex */
public interface f<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
