package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<b> implements i<Object> {
    public static final long serialVersionUID = 8663801314800248617L;
    public final MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> parent;

    public MaybeTimeoutMaybe$TimeoutOtherMaybeObserver(MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> maybeTimeoutMaybe$TimeoutMainMaybeObserver) {
        this.parent = maybeTimeoutMaybe$TimeoutMainMaybeObserver;
    }

    @Override // f.b.i
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.parent.otherError(th);
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.i
    public void onSuccess(Object obj) {
        this.parent.otherComplete();
    }
}
