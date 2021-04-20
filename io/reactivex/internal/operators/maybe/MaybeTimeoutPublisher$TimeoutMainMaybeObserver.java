package io.reactivex.internal.operators.maybe;

import f.b.a0.a;
import f.b.i;
import f.b.j;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = -5955289211445418871L;
    public final i<? super T> actual;
    public final j<? extends T> fallback;
    public final MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> other = new MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<>(this);
    public final MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> otherObserver;

    public MaybeTimeoutPublisher$TimeoutMainMaybeObserver(i<? super T> iVar, j<? extends T> jVar) {
        this.actual = iVar;
        this.fallback = jVar;
        this.otherObserver = jVar != null ? new MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<>(iVar) : null;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
        MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> maybeTimeoutPublisher$TimeoutFallbackMaybeObserver = this.otherObserver;
        if (maybeTimeoutPublisher$TimeoutFallbackMaybeObserver != null) {
            DisposableHelper.dispose(maybeTimeoutPublisher$TimeoutFallbackMaybeObserver);
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.i
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onComplete();
        }
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        SubscriptionHelper.cancel(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onError(th);
        } else {
            a.f(th);
        }
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        SubscriptionHelper.cancel(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onSuccess(t);
        }
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this)) {
            j<? extends T> jVar = this.fallback;
            if (jVar == null) {
                this.actual.onError(new TimeoutException());
            } else {
                jVar.a(this.otherObserver);
            }
        }
    }

    public void otherError(Throwable th) {
        if (DisposableHelper.dispose(this)) {
            this.actual.onError(th);
        } else {
            a.f(th);
        }
    }
}
