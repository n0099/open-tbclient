package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    public final long n;

    /* loaded from: classes7.dex */
    public static final class SkipObserver<T> implements Observer<T>, Disposable {
        public final Observer<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72322d;
        public long remaining;

        public SkipObserver(Observer<? super T> observer, long j) {
            this.actual = observer;
            this.remaining = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72322d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72322d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            long j = this.remaining;
            if (j != 0) {
                this.remaining = j - 1;
            } else {
                this.actual.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72322d, disposable)) {
                this.f72322d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.n = j;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.n));
    }
}
