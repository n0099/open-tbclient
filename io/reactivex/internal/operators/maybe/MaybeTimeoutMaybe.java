package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class MaybeTimeoutMaybe<T, U> extends a<T, T> {
    final o<? extends T> fallback;
    final o<U> other;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(mVar, this.fallback);
        mVar.onSubscribe(timeoutMainMaybeObserver);
        this.other.a(timeoutMainMaybeObserver.other);
        this.source.a(timeoutMainMaybeObserver);
    }

    /* loaded from: classes5.dex */
    static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -5955289211445418871L;
        final m<? super T> actual;
        final o<? extends T> fallback;
        final TimeoutOtherMaybeObserver<T, U> other = new TimeoutOtherMaybeObserver<>(this);
        final TimeoutFallbackMaybeObserver<T> otherObserver;

        TimeoutMainMaybeObserver(m<? super T> mVar, o<? extends T> oVar) {
            this.actual = mVar;
            this.fallback = oVar;
            this.otherObserver = oVar != null ? new TimeoutFallbackMaybeObserver<>(mVar) : null;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.otherObserver;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.dispose(timeoutFallbackMaybeObserver);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            DisposableHelper.dispose(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.m
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onComplete();
            }
        }

        public void otherError(Throwable th) {
            if (DisposableHelper.dispose(this)) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this)) {
                if (this.fallback == null) {
                    this.actual.onError(new TimeoutException());
                } else {
                    this.fallback.a(this.otherObserver);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements m<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final TimeoutMainMaybeObserver<T, U> parent;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.parent = timeoutMainMaybeObserver;
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(Object obj) {
            this.parent.otherComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.parent.otherComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
        private static final long serialVersionUID = 8663801314800248617L;
        final m<? super T> actual;

        TimeoutFallbackMaybeObserver(m<? super T> mVar) {
            this.actual = mVar;
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
