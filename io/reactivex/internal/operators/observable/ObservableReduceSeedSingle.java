package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes7.dex */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
    public final BiFunction<R, ? super T, R> reducer;
    public final R seed;
    public final ObservableSource<T> source;

    /* loaded from: classes7.dex */
    public static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        public final SingleObserver<? super R> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f69010d;
        public final BiFunction<R, ? super T, R> reducer;
        public R value;

        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.actual = singleObserver;
            this.value = r;
            this.reducer = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f69010d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f69010d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            R r = this.value;
            if (r != null) {
                this.value = null;
                this.actual.onSuccess(r);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.value != null) {
                this.value = null;
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            R r = this.value;
            if (r != null) {
                try {
                    this.value = (R) ObjectHelper.requireNonNull(this.reducer.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f69010d.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f69010d, disposable)) {
                this.f69010d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.source = observableSource;
        this.seed = r;
        this.reducer = biFunction;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new ReduceSeedObserver(singleObserver, this.reducer, this.seed));
    }
}
