package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
/* loaded from: classes8.dex */
public interface MaybeEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable th);

    void onSuccess(Object obj);

    void setCancellable(Cancellable cancellable);

    void setDisposable(Disposable disposable);

    boolean tryOnError(Throwable th);
}
