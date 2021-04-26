package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes7.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {
    public final Consumer<? super Disposable> onSubscribe;
    public final SingleSource<T> source;

    /* loaded from: classes7.dex */
    public static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
        public final SingleObserver<? super T> actual;
        public boolean done;
        public final Consumer<? super Disposable> onSubscribe;

        public DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.actual = singleObserver;
            this.onSubscribe = consumer;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            try {
                this.onSubscribe.accept(disposable);
                this.actual.onSubscribe(disposable);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.done = true;
                disposable.dispose();
                EmptyDisposable.error(th, this.actual);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            if (this.done) {
                return;
            }
            this.actual.onSuccess(t);
        }
    }

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.source = singleSource;
        this.onSubscribe = consumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnSubscribeSingleObserver(singleObserver, this.onSubscribe));
    }
}
