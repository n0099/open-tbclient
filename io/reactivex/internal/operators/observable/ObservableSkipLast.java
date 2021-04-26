package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
/* loaded from: classes7.dex */
public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {
    public final int skip;

    /* loaded from: classes7.dex */
    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        public static final long serialVersionUID = -3807491841935125653L;
        public final Observer<? super T> actual;
        public Disposable s;
        public final int skip;

        public SkipLastObserver(Observer<? super T> observer, int i2) {
            super(i2);
            this.actual = observer;
            this.skip = i2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext((T) poll());
            }
            offer(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.skip = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipLastObserver(observer, this.skip));
    }
}
