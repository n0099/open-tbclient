package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
@Experimental
/* loaded from: classes7.dex */
public final class SingleDoAfterSuccess<T> extends Single<T> {
    public final Consumer<? super T> onAfterSuccess;
    public final SingleSource<T> source;

    /* loaded from: classes7.dex */
    public static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {
        public final SingleObserver<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f69018d;
        public final Consumer<? super T> onAfterSuccess;

        public DoAfterObserver(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.actual = singleObserver;
            this.onAfterSuccess = consumer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f69018d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f69018d.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f69018d, disposable)) {
                this.f69018d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            try {
                this.onAfterSuccess.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onAfterSuccess = consumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoAfterObserver(singleObserver, this.onAfterSuccess));
    }
}
