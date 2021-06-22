package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {
    public final T defaultValue;
    public final MaybeSource<T> source;

    /* loaded from: classes7.dex */
    public static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {
        public final SingleObserver<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72406d;
        public final T defaultValue;

        public ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.actual = singleObserver;
            this.defaultValue = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72406d.dispose();
            this.f72406d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72406d.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f72406d = DisposableHelper.DISPOSED;
            T t = this.defaultValue;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f72406d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72406d, disposable)) {
                this.f72406d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.f72406d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(t);
        }
    }

    public MaybeToSingle(MaybeSource<T> maybeSource, T t) {
        this.source = maybeSource;
        this.defaultValue = t;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ToSingleMaybeSubscriber(singleObserver, this.defaultValue));
    }
}
