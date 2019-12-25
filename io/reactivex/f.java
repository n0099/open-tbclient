package io.reactivex;
/* loaded from: classes4.dex */
public interface f<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
