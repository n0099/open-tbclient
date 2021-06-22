package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class MaybeIgnoreElement<T> extends AbstractMaybeWithUpstream<T, T> {

    /* loaded from: classes7.dex */
    public static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        public final MaybeObserver<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72395d;

        public IgnoreMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72395d.dispose();
            this.f72395d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72395d.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f72395d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f72395d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72395d, disposable)) {
                this.f72395d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.f72395d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }
    }

    public MaybeIgnoreElement(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new IgnoreMaybeObserver(maybeObserver));
    }
}
