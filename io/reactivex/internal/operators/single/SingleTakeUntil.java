package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.b.d;
/* loaded from: classes7.dex */
public final class SingleTakeUntil<T, U> extends w<T> {
    final org.b.b<U> onu;
    final aa<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(yVar);
        yVar.onSubscribe(takeUntilMainObserver);
        this.onu.subscribe(takeUntilMainObserver.other);
        this.source.a(takeUntilMainObserver);
    }

    /* loaded from: classes7.dex */
    static final class TakeUntilMainObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T> {
        private static final long serialVersionUID = -622603812305745221L;
        final y<? super T> actual;
        final TakeUntilOtherSubscriber other = new TakeUntilOtherSubscriber(this);

        TakeUntilMainObserver(y<? super T> yVar) {
            this.actual = yVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            this.other.dispose();
            if (get() != DisposableHelper.DISPOSED && getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.other.dispose();
            if (get() != DisposableHelper.DISPOSED && getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        void otherError(Throwable th) {
            io.reactivex.disposables.b andSet;
            if (get() != DisposableHelper.DISPOSED && (andSet = getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                if (andSet != null) {
                    andSet.dispose();
                }
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    static final class TakeUntilOtherSubscriber extends AtomicReference<d> implements j<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final TakeUntilMainObserver<?> parent;

        TakeUntilOtherSubscriber(TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.parent = takeUntilMainObserver;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.otherError(new CancellationException());
            }
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }
    }
}
