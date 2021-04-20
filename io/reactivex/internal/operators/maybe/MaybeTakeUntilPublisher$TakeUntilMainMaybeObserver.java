package io.reactivex.internal.operators.maybe;

import f.b.a0.a;
import f.b.g;
import f.b.i;
import f.b.t.b;
import g.d.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<T, U> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = -2187421758664251153L;
    public final i<? super T> actual;
    public final TakeUntilOtherMaybeObserver<U> other = new TakeUntilOtherMaybeObserver<>(this);

    /* loaded from: classes7.dex */
    public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<d> implements g<U> {
        public static final long serialVersionUID = -1266041316834525931L;
        public final MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> parent;

        public TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> maybeTakeUntilPublisher$TakeUntilMainMaybeObserver) {
            this.parent = maybeTakeUntilPublisher$TakeUntilMainMaybeObserver;
        }

        @Override // g.d.c
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // g.d.c
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // g.d.c
        public void onNext(Object obj) {
            this.parent.otherComplete();
        }

        @Override // f.b.g, g.d.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver(i<? super T> iVar) {
        this.actual = iVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
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
