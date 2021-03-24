package io.reactivex.internal.operators.maybe;

import f.a.a0.a;
import f.a.i;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver<T, U> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = -2187421758664251153L;
    public final i<? super T> actual;
    public final TakeUntilOtherMaybeObserver<U> other = new TakeUntilOtherMaybeObserver<>(this);

    /* loaded from: classes7.dex */
    public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<b> implements i<U> {
        public static final long serialVersionUID = -1266041316834525931L;
        public final MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver<?, U> parent;

        public TakeUntilOtherMaybeObserver(MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver<?, U> maybeTakeUntilMaybe$TakeUntilMainMaybeObserver) {
            this.parent = maybeTakeUntilMaybe$TakeUntilMainMaybeObserver;
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

    public MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver(i<? super T> iVar) {
        this.actual = iVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
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
            this.actual.onComplete();
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
