package io.reactivex;

import io.reactivex.disposables.Disposable;
/* loaded from: classes8.dex */
public interface Observer {
    void onComplete();

    void onError(Throwable th);

    void onNext(Object obj);

    void onSubscribe(Disposable disposable);
}
