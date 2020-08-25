package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;
import org.b.d;
/* loaded from: classes7.dex */
public final class MaybeTakeUntilPublisher<T, U> extends a<T, T> {
    final org.b.b<U> onb;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(mVar);
        mVar.onSubscribe(takeUntilMainMaybeObserver);
        this.onb.subscribe(takeUntilMainMaybeObserver.other);
        this.source.a(takeUntilMainMaybeObserver);
    }

    /* loaded from: classes7.dex */
    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -2187421758664251153L;
        final m<? super T> actual;
        final TakeUntilOtherMaybeObserver<U> other = new TakeUntilOtherMaybeObserver<>(this);

        TakeUntilMainMaybeObserver(m<? super T> mVar) {
            this.actual = mVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.m
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onComplete();
            }
        }

        void otherError(Throwable th) {
            if (DisposableHelper.dispose(this)) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        void otherComplete() {
            if (DisposableHelper.dispose(this)) {
                this.actual.onComplete();
            }
        }

        /* loaded from: classes7.dex */
        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<d> implements j<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> parent;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.parent = takeUntilMainMaybeObserver;
            }

            @Override // io.reactivex.j, org.b.c
            public void onSubscribe(d dVar) {
                if (SubscriptionHelper.setOnce(this, dVar)) {
                    dVar.request(Long.MAX_VALUE);
                }
            }

            @Override // org.b.c
            public void onNext(Object obj) {
                this.parent.otherComplete();
            }

            @Override // org.b.c
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // org.b.c
            public void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
