package io.reactivex.internal.operators.observable;

import io.reactivex.b.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableCreate<T> extends q<T> {
    final s<T> qfo;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        CreateEmitter createEmitter = new CreateEmitter(uVar);
        uVar.onSubscribe(createEmitter);
        try {
            this.qfo.a(createEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.O(th);
            createEmitter.onError(th);
        }
    }

    /* loaded from: classes5.dex */
    static final class CreateEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, r<T> {
        private static final long serialVersionUID = -3434801548987643227L;
        final u<? super T> observer;

        CreateEmitter(u<? super T> uVar) {
            this.observer = uVar;
        }

        @Override // io.reactivex.f
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.observer.onNext(t);
            }
        }

        @Override // io.reactivex.f
        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.d.a.onError(th);
            }
        }

        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!isDisposed()) {
                try {
                    this.observer.onError(th);
                    dispose();
                    return true;
                } catch (Throwable th2) {
                    dispose();
                    throw th2;
                }
            }
            return false;
        }

        @Override // io.reactivex.f
        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.observer.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        @Override // io.reactivex.r
        public void setDisposable(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // io.reactivex.r
        public void setCancellable(f fVar) {
            setDisposable(new CancellableDisposable(fVar));
        }

        public r<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    /* loaded from: classes5.dex */
    static final class SerializedEmitter<T> extends AtomicInteger implements r<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final r<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final io.reactivex.internal.queue.a<T> queue = new io.reactivex.internal.queue.a<>(16);

        SerializedEmitter(r<T> rVar) {
            this.emitter = rVar;
        }

        @Override // io.reactivex.f
        public void onNext(T t) {
            if (!this.emitter.isDisposed() && !this.done) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.emitter.onNext(t);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    io.reactivex.internal.queue.a<T> aVar = this.queue;
                    synchronized (aVar) {
                        aVar.offer(t);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.f
        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.d.a.onError(th);
            }
        }

        public boolean tryOnError(Throwable th) {
            if (this.emitter.isDisposed() || this.done) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (this.error.addThrowable(th)) {
                this.done = true;
                drain();
                return true;
            }
            return false;
        }

        @Override // io.reactivex.f
        public void onComplete() {
            if (!this.emitter.isDisposed() && !this.done) {
                this.done = true;
                drain();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            r<T> rVar = this.emitter;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i = 1;
            while (!rVar.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    aVar.clear();
                    rVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                T poll = aVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    rVar.onComplete();
                    return;
                } else if (!z2) {
                    rVar.onNext(poll);
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            aVar.clear();
        }

        @Override // io.reactivex.r
        public void setDisposable(io.reactivex.disposables.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        @Override // io.reactivex.r
        public void setCancellable(f fVar) {
            this.emitter.setCancellable(fVar);
        }

        @Override // io.reactivex.r
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        public r<T> serialize() {
            return this;
        }
    }
}
