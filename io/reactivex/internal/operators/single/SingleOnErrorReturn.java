package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
/* loaded from: classes7.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {
    public final SingleSource<? extends T> source;
    public final T value;
    public final Function<? super Throwable, ? extends T> valueSupplier;

    /* loaded from: classes7.dex */
    public final class OnErrorReturn implements SingleObserver<T> {
        public final SingleObserver<? super T> observer;

        public OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            T apply;
            SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
            Function<? super Throwable, ? extends T> function = singleOnErrorReturn.valueSupplier;
            if (function != null) {
                try {
                    apply = function.apply(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.observer.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                apply = singleOnErrorReturn.value;
            }
            if (apply == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.observer.onError(nullPointerException);
                return;
            }
            this.observer.onSuccess(apply);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.observer.onSuccess(t);
        }
    }

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.source = singleSource;
        this.valueSupplier = function;
        this.value = t;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new OnErrorReturn(singleObserver));
    }
}
