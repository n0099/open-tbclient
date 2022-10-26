package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
/* loaded from: classes8.dex */
public interface ObservableEmitter extends Emitter {
    boolean isDisposed();

    ObservableEmitter serialize();

    void setCancellable(Cancellable cancellable);

    void setDisposable(Disposable disposable);

    boolean tryOnError(Throwable th);
}
