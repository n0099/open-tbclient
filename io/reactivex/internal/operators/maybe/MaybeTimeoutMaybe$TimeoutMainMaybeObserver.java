package io.reactivex.internal.operators.maybe;

import f.a.a0.a;
import f.a.i;
import f.a.j;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = -5955289211445418871L;
    public final i<? super T> actual;
    public final j<? extends T> fallback;
    public final MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> other = new MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<>(this);
    public final MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> otherObserver;

    public MaybeTimeoutMaybe$TimeoutMainMaybeObserver(i<? super T> iVar, j<? extends T> jVar) {
        this.actual = iVar;
        this.fallback = jVar;
        this.otherObserver = jVar != null ? new MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<>(iVar) : null;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> maybeTimeoutMaybe$TimeoutFallbackMaybeObserver = this.otherObserver;
        if (maybeTimeoutMaybe$TimeoutFallbackMaybeObserver != null) {
            DisposableHelper.dispose(maybeTimeoutMaybe$TimeoutFallbackMaybeObserver);
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.i
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onComplete();
        }
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        DisposableHelper.dispose(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onError(th);
        } else {
            a.f(th);
        }
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        DisposableHelper.dispose(this.other);
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
