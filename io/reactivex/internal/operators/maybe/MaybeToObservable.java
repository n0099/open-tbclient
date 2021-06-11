package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;
/* loaded from: classes7.dex */
public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {
    public final MaybeSource<T> source;

    /* loaded from: classes7.dex */
    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        public static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72301d;

        public MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.f72301d.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            error(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72301d, disposable)) {
                this.f72301d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Experimental
    public static <T> MaybeObserver<T> create(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(create(observer));
    }
}
