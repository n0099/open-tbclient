package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes7.dex */
public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {
    public final MaybeSource<T> source;

    /* loaded from: classes7.dex */
    public static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        public final CompletableObserver actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72292d;

        public IgnoreMaybeObserver(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72292d.dispose();
            this.f72292d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72292d.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f72292d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f72292d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72292d, disposable)) {
                this.f72292d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.f72292d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }
    }

    public MaybeIgnoreElementCompletable(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToMaybe
    public Maybe<T> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElement(this.source));
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreMaybeObserver(completableObserver));
    }
}
