package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class ObservableTakeUntil<T, U> extends a<T, T> {
    final t<? extends U> other;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(uVar);
        uVar.onSubscribe(takeUntilMainObserver);
        this.other.subscribe(takeUntilMainObserver.otherObserver);
        this.source.subscribe(takeUntilMainObserver);
    }

    /* loaded from: classes4.dex */
    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 1418547743690811973L;
        final u<? super T> downstream;
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        final AtomicThrowable error = new AtomicThrowable();

        TakeUntilMainObserver(u<? super T> uVar) {
            this.downstream = uVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            e.a(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            e.a((u<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            e.a(this.downstream, this, this.error);
        }

        void otherError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            e.a((u<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            e.a(this.downstream, this, this.error);
        }

        /* loaded from: classes4.dex */
        final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements u<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            OtherObserver() {
            }

            @Override // io.reactivex.u
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.u
            public void onNext(U u) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.otherComplete();
            }

            @Override // io.reactivex.u
            public void onError(Throwable th) {
                TakeUntilMainObserver.this.otherError(th);
            }

            @Override // io.reactivex.u
            public void onComplete() {
                TakeUntilMainObserver.this.otherComplete();
            }
        }
    }
}
