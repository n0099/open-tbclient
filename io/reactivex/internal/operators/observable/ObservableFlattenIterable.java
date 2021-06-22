package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes7.dex */
public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function<? super T, ? extends Iterable<? extends R>> mapper;

    /* loaded from: classes7.dex */
    public static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        public final Observer<? super R> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72417d;
        public final Function<? super T, ? extends Iterable<? extends R>> mapper;

        public FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.actual = observer;
            this.mapper = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72417d.dispose();
            this.f72417d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72417d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Disposable disposable = this.f72417d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            this.f72417d = disposableHelper;
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Disposable disposable = this.f72417d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f72417d = disposableHelper;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.f72417d == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Observer<? super R> observer = this.actual;
                for (R r : this.mapper.apply(t)) {
                    try {
                        try {
                            observer.onNext((Object) ObjectHelper.requireNonNull(r, "The iterator returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f72417d.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f72417d.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f72417d.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72417d, disposable)) {
                this.f72417d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.mapper = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlattenIterableObserver(observer, this.mapper));
    }
}
