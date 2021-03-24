package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver<T> extends AtomicReference<b> implements i<T> {
    public static final long serialVersionUID = 706635022205076709L;
    public final i<? super T> actual;

    public MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver(i<? super T> iVar) {
        this.actual = iVar;
    }

    @Override // f.a.i
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
