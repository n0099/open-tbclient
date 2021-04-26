package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
/* loaded from: classes7.dex */
public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {
    public final int count;

    /* loaded from: classes7.dex */
    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        public static final long serialVersionUID = 7240042530241604978L;
        public final Observer<? super T> actual;
        public volatile boolean cancelled;
        public final int count;
        public Disposable s;

        public TakeLastObserver(Observer<? super T> observer, int i2) {
            this.actual = observer;
            this.count = i2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer<? super T> observer = this.actual;
            while (!this.cancelled) {
                Object obj = (T) poll();
                if (obj == null) {
                    if (this.cancelled) {
                        return;
                    }
                    observer.onComplete();
                    return;
                }
                observer.onNext(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
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

    public ObservableTakeLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.count = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastObserver(observer, this.count));
    }
}
