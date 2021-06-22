package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes7.dex */
public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {
    public final ObservableSource<T> source;

    /* loaded from: classes7.dex */
    public static final class CountObserver implements Observer<Object>, Disposable {
        public final SingleObserver<? super Long> actual;
        public long count;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72411d;

        public CountObserver(SingleObserver<? super Long> singleObserver) {
            this.actual = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72411d.dispose();
            this.f72411d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72411d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f72411d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(Long.valueOf(this.count));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f72411d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.count++;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72411d, disposable)) {
                this.f72411d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Long> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCount(this.source));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe(new CountObserver(singleObserver));
    }
}
