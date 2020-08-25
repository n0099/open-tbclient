package io.reactivex.internal.operators.observable;

import io.reactivex.c.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.observable.a<T, R> {
    final c<? super T, ? super U, ? extends R> combiner;
    final t<? extends U> other;

    @Override // io.reactivex.q
    public void a(u<? super R> uVar) {
        io.reactivex.observers.b bVar = new io.reactivex.observers.b(uVar);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(bVar, this.combiner);
        bVar.onSubscribe(withLatestFromObserver);
        this.other.subscribe(new a(withLatestFromObserver));
        this.source.subscribe(withLatestFromObserver);
    }

    /* loaded from: classes7.dex */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -312246233408980075L;
        final u<? super R> actual;
        final c<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<io.reactivex.disposables.b> s = new AtomicReference<>();
        final AtomicReference<io.reactivex.disposables.b> other = new AtomicReference<>();

        WithLatestFromObserver(u<? super R> uVar, c<? super T, ? super U, ? extends R> cVar) {
            this.actual = uVar;
            this.combiner = cVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.s, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(io.reactivex.internal.functions.a.k(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    dispose();
                    this.actual.onError(th);
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.s);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.s.get());
        }

        public boolean setOther(io.reactivex.disposables.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.s);
            this.actual.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    final class a implements u<U> {
        private final WithLatestFromObserver<T, U, R> ooC;

        a(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.ooC = withLatestFromObserver;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.ooC.setOther(bVar);
        }

        @Override // io.reactivex.u
        public void onNext(U u) {
            this.ooC.lazySet(u);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.ooC.otherError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
        }
    }
}
