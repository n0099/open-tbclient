package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
@Experimental
/* loaded from: classes7.dex */
public final class SingleDetach<T> extends Single<T> {
    public final SingleSource<T> source;

    /* loaded from: classes7.dex */
    public static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        public SingleObserver<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72430d;

        public DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.actual = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.actual = null;
            this.f72430d.dispose();
            this.f72430d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72430d.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f72430d = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.actual;
            if (singleObserver != null) {
                this.actual = null;
                singleObserver.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72430d, disposable)) {
                this.f72430d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.f72430d = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.actual;
            if (singleObserver != null) {
                this.actual = null;
                singleObserver.onSuccess(t);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DetachSingleObserver(singleObserver));
    }
}
