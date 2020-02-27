package io.reactivex.internal.operators.maybe;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes7.dex */
public final class MaybeTimeoutPublisher<T, U> extends a<T, T> {
    final o<? extends T> fallback;
    final org.a.b<U> other;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(mVar, this.fallback);
        mVar.onSubscribe(timeoutMainMaybeObserver);
        this.other.subscribe(timeoutMainMaybeObserver.other);
        this.source.a(timeoutMainMaybeObserver);
    }

    /* loaded from: classes7.dex */
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
            SubscriptionHelper.cancel(this.other);
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
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.m
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
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

    /* loaded from: classes7.dex */
    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<d> implements j<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final TimeoutMainMaybeObserver<T, U> parent;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.parent = timeoutMainMaybeObserver;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.setOnce(this, dVar, Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            get().cancel();
            this.parent.otherComplete();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.otherComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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
