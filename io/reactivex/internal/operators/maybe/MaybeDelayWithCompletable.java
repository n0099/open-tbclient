package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeDelayWithCompletable<T> extends Maybe<T> {
    public final CompletableSource other;
    public final MaybeSource<T> source;

    /* loaded from: classes7.dex */
    public static final class DelayWithMainObserver<T> implements MaybeObserver<T> {
        public final MaybeObserver<? super T> actual;
        public final AtomicReference<Disposable> parent;

        public DelayWithMainObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super T> maybeObserver) {
            this.parent = atomicReference;
            this.actual = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.parent, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* loaded from: classes7.dex */
    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        public static final long serialVersionUID = 703409937383992161L;
        public final MaybeObserver<? super T> actual;
        public final MaybeSource<T> source;

        public OtherObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.actual = maybeObserver;
            this.source = maybeSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.source.subscribe(new DelayWithMainObserver(this, this.actual));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public MaybeDelayWithCompletable(MaybeSource<T> maybeSource, CompletableSource completableSource) {
        this.source = maybeSource;
        this.other = completableSource;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.other.subscribe(new OtherObserver(maybeObserver, this.source));
    }
}
