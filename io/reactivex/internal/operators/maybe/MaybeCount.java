package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
/* loaded from: classes7.dex */
public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {
    public final MaybeSource<T> source;

    /* loaded from: classes7.dex */
    public static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {
        public final SingleObserver<? super Long> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72380d;

        public CountMaybeObserver(SingleObserver<? super Long> singleObserver) {
            this.actual = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72380d.dispose();
            this.f72380d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72380d.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f72380d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(0L);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f72380d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72380d, disposable)) {
                this.f72380d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f72380d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(1L);
        }
    }

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe(new CountMaybeObserver(singleObserver));
    }
}
