package io.reactivex;

import io.reactivex.disposables.Disposable;
/* loaded from: classes8.dex */
public interface MaybeObserver {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(Disposable disposable);

    void onSuccess(Object obj);
}
