package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
/* loaded from: classes10.dex */
public interface SingleObserver<T> {
    void onError(@NonNull Throwable th);

    void onSubscribe(@NonNull Disposable disposable);

    void onSuccess(@NonNull T t);
}
