package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
@Experimental
/* loaded from: classes7.dex */
public final class CompletableDetach extends Completable {
    public final CompletableSource source;

    /* loaded from: classes7.dex */
    public static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        public CompletableObserver actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f68236d;

        public DetachCompletableObserver(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.actual = null;
            this.f68236d.dispose();
            this.f68236d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f68236d.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f68236d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.actual;
            if (completableObserver != null) {
                this.actual = null;
                completableObserver.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f68236d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.actual;
            if (completableObserver != null) {
                this.actual = null;
                completableObserver.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f68236d, disposable)) {
                this.f68236d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public CompletableDetach(CompletableSource completableSource) {
        this.source = completableSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new DetachCompletableObserver(completableObserver));
    }
}
