package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableSubscribeOn<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final v scheduler;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(uVar);
        uVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.scheduler.C(new a(subscribeOnObserver)));
    }

    /* loaded from: classes7.dex */
    static final class SubscribeOnObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 8094547886072529208L;
        final u<? super T> actual;
        final AtomicReference<io.reactivex.disposables.b> s = new AtomicReference<>();

        SubscribeOnObserver(u<? super T> uVar) {
            this.actual = uVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.s, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.s);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        void setDisposable(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* loaded from: classes7.dex */
    final class a implements Runnable {
        private final SubscribeOnObserver<T> nAg;

        a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.nAg = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.source.subscribe(this.nAg);
        }
    }
}
