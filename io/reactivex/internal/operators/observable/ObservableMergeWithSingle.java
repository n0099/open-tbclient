package io.reactivex.internal.operators.observable;

import io.reactivex.aa;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableMergeWithSingle<T> extends a<T, T> {
    final aa<? extends T> other;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(uVar);
        uVar.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.other.a(mergeWithObserver.otherObserver);
    }

    /* loaded from: classes5.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        final u<? super T> actual;
        volatile boolean disposed;
        volatile boolean mainDone;
        volatile int otherState;
        volatile f<T> queue;
        T singleItem;
        final AtomicReference<io.reactivex.disposables.b> mainDisposable = new AtomicReference<>();
        final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        final AtomicThrowable error = new AtomicThrowable();

        MergeWithObserver(u<? super T> uVar) {
            this.actual = uVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.actual.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                this.actual.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void otherError(Throwable th) {
            if (this.error.addThrowable(th)) {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        f<T> getOrCreateQueue() {
            f<T> fVar = this.queue;
            if (fVar == null) {
                io.reactivex.internal.queue.a aVar = new io.reactivex.internal.queue.a(q.dHT());
                this.queue = aVar;
                return aVar;
            }
            return fVar;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX DEBUG: Type inference failed for r2v5. Raw type applied. Possible types: T, ? super T */
        void drainLoop() {
            u<? super T> uVar = this.actual;
            int i = 1;
            while (!this.disposed) {
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    uVar.onError(this.error.terminate());
                    return;
                }
                int i2 = this.otherState;
                if (i2 == 1) {
                    this.singleItem = null;
                    this.otherState = 2;
                    uVar.onNext((T) this.singleItem);
                    i2 = 2;
                }
                boolean z = this.mainDone;
                f<T> fVar = this.queue;
                Object obj = fVar != null ? (Object) fVar.poll() : (Object) null;
                boolean z2 = obj == null;
                if (z && z2 && i2 == 2) {
                    this.queue = null;
                    uVar.onComplete();
                    return;
                } else if (!z2) {
                    uVar.onNext(obj);
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        /* loaded from: classes5.dex */
        static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements y<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.y
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.y
            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }

            @Override // io.reactivex.y
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }
        }
    }
}
