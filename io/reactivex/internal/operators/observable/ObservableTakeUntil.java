package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes17.dex */
public final class ObservableTakeUntil<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {
    final t<? extends U> other;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        io.reactivex.observers.b bVar = new io.reactivex.observers.b(uVar);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        TakeUntilObserver takeUntilObserver = new TakeUntilObserver(bVar, arrayCompositeDisposable);
        uVar.onSubscribe(arrayCompositeDisposable);
        this.other.subscribe(new a(arrayCompositeDisposable, bVar));
        this.source.subscribe(takeUntilObserver);
    }

    /* loaded from: classes17.dex */
    static final class TakeUntilObserver<T> extends AtomicBoolean implements u<T> {
        private static final long serialVersionUID = 3451719290311127173L;
        final u<? super T> actual;
        final ArrayCompositeDisposable frc;
        io.reactivex.disposables.b s;

        TakeUntilObserver(u<? super T> uVar, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.actual = uVar;
            this.frc = arrayCompositeDisposable;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.frc.setResource(0, bVar);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.frc.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.frc.dispose();
            this.actual.onComplete();
        }
    }

    /* loaded from: classes17.dex */
    final class a implements u<U> {
        private final ArrayCompositeDisposable frc;
        private final io.reactivex.observers.b<T> pOC;

        a(ArrayCompositeDisposable arrayCompositeDisposable, io.reactivex.observers.b<T> bVar) {
            this.frc = arrayCompositeDisposable;
            this.pOC = bVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.frc.setResource(1, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(U u) {
            this.frc.dispose();
            this.pOC.onComplete();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.frc.dispose();
            this.pOC.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.frc.dispose();
            this.pOC.onComplete();
        }
    }
}
