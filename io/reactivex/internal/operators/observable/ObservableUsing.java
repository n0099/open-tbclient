package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableUsing<T, D> extends Observable<T> {
    public final Consumer<? super D> disposer;
    public final boolean eager;
    public final Callable<? extends D> resourceSupplier;
    public final Function<? super D, ? extends ObservableSource<? extends T>> sourceSupplier;

    /* loaded from: classes7.dex */
    public static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        public static final long serialVersionUID = 5904473792286235046L;
        public final Observer<? super T> actual;
        public final Consumer<? super D> disposer;
        public final boolean eager;
        public final D resource;
        public Disposable s;

        public UsingObserver(Observer<? super T> observer, D d2, Consumer<? super D> consumer, boolean z) {
            this.actual = observer;
            this.resource = d2;
            this.disposer = consumer;
            this.eager = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            disposeAfter();
            this.s.dispose();
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: D, ? super D */
        public void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: D, ? super D */
        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.s.dispose();
                this.actual.onComplete();
                return;
            }
            this.actual.onComplete();
            this.s.dispose();
            disposeAfter();
        }

        /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: D, ? super D */
        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.s.dispose();
                this.actual.onError(th);
                return;
            }
            this.actual.onError(th);
            this.s.dispose();
            disposeAfter();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.disposer = consumer;
        this.eager = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            D call = this.resourceSupplier.call();
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.sourceSupplier.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.disposer, this.eager));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                try {
                    this.disposer.accept(call);
                    EmptyDisposable.error(th, observer);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptyDisposable.error(new CompositeException(th, th2), observer);
                }
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, observer);
        }
    }
}
