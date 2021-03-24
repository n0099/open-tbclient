package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<b> implements i<Object> {
    public static final long serialVersionUID = 8663801314800248617L;
    public final MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> parent;

    public MaybeTimeoutMaybe$TimeoutOtherMaybeObserver(MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> maybeTimeoutMaybe$TimeoutMainMaybeObserver) {
        this.parent = maybeTimeoutMaybe$TimeoutMainMaybeObserver;
    }

    @Override // f.a.i
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.parent.otherError(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.i
    public void onSuccess(Object obj) {
        this.parent.otherComplete();
    }
}
