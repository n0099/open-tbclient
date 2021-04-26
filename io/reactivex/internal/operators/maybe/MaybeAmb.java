package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class MaybeAmb<T> extends Maybe<T> {
    public final MaybeSource<? extends T>[] sources;
    public final Iterable<? extends MaybeSource<? extends T>> sourcesIterable;

    /* loaded from: classes7.dex */
    public static final class AmbMaybeObserver<T> extends AtomicBoolean implements MaybeObserver<T>, Disposable {
        public static final long serialVersionUID = -7044685185359438206L;
        public final MaybeObserver<? super T> actual;
        public final CompositeDisposable set = new CompositeDisposable();

        public AmbMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onSuccess(t);
            }
        }
    }

    public MaybeAmb(MaybeSource<? extends T>[] maybeSourceArr, Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.sources = maybeSourceArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        int length;
        MaybeSource<? extends T>[] maybeSourceArr = this.sources;
        if (maybeSourceArr == null) {
            maybeSourceArr = new MaybeSource[8];
            try {
                length = 0;
                for (MaybeSource<? extends T> maybeSource : this.sourcesIterable) {
                    if (maybeSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), maybeObserver);
                        return;
                    }
                    if (length == maybeSourceArr.length) {
                        MaybeSource<? extends T>[] maybeSourceArr2 = new MaybeSource[(length >> 2) + length];
                        System.arraycopy(maybeSourceArr, 0, maybeSourceArr2, 0, length);
                        maybeSourceArr = maybeSourceArr2;
                    }
                    int i2 = length + 1;
                    maybeSourceArr[length] = maybeSource;
                    length = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, maybeObserver);
                return;
            }
        } else {
            length = maybeSourceArr.length;
        }
        AmbMaybeObserver ambMaybeObserver = new AmbMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(ambMaybeObserver);
        for (int i3 = 0; i3 < length; i3++) {
            MaybeSource<? extends T> maybeSource2 = maybeSourceArr[i3];
            if (ambMaybeObserver.isDisposed()) {
                return;
            }
            if (maybeSource2 == null) {
                ambMaybeObserver.onError(new NullPointerException("One of the MaybeSources is null"));
                return;
            }
            maybeSource2.subscribe(ambMaybeObserver);
        }
        if (length == 0) {
            maybeObserver.onComplete();
        }
    }
}
