package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class ObservableFlatMapMaybe<T, R> extends a<T, R> {
    final boolean delayErrors;
    final h<? super T, ? extends o<? extends R>> mapper;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        this.source.subscribe(new FlatMapMaybeObserver(uVar, this.mapper, this.delayErrors));
    }

    /* loaded from: classes17.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 8600231336733376951L;
        final u<? super R> actual;
        volatile boolean cancelled;
        io.reactivex.disposables.b d;
        final boolean delayErrors;
        final h<? super T, ? extends o<? extends R>> mapper;
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<io.reactivex.internal.queue.a<R>> queue = new AtomicReference<>();

        FlatMapMaybeObserver(u<? super R> uVar, h<? super T, ? extends o<? extends R>> hVar, boolean z) {
            this.actual = uVar;
            this.mapper = hVar;
            this.delayErrors = z;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            try {
                o oVar = (o) io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.cancelled && this.set.a(innerObserver)) {
                    oVar.a(innerObserver);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                this.d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.d.dispose();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerSuccess(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r) {
            this.set.c(innerObserver);
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(r);
                boolean z = this.active.decrementAndGet() == 0;
                io.reactivex.internal.queue.a<R> aVar = this.queue.get();
                if (z && (aVar == null || aVar.isEmpty())) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.actual.onError(terminate);
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                } else if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.internal.queue.a<R> orCreateQueue = getOrCreateQueue();
                synchronized (orCreateQueue) {
                    orCreateQueue.offer(r);
                }
                this.active.decrementAndGet();
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        io.reactivex.internal.queue.a<R> getOrCreateQueue() {
            io.reactivex.internal.queue.a<R> aVar;
            do {
                aVar = this.queue.get();
                if (aVar != null) {
                    break;
                }
                aVar = new io.reactivex.internal.queue.a<>(q.eAv());
            } while (!this.queue.compareAndSet(null, aVar));
            return aVar;
        }

        void innerError(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.d.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            if (get() == 0 && compareAndSet(0, 1)) {
                boolean z = this.active.decrementAndGet() == 0;
                io.reactivex.internal.queue.a<R> aVar = this.queue.get();
                if (z && (aVar == null || aVar.isEmpty())) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.actual.onError(terminate);
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                } else if (decrementAndGet() != 0) {
                    drainLoop();
                    return;
                } else {
                    return;
                }
            }
            this.active.decrementAndGet();
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void clear() {
            io.reactivex.internal.queue.a<R> aVar = this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        void drainLoop() {
            u<? super R> uVar = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<io.reactivex.internal.queue.a<R>> atomicReference = this.queue;
            int i = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable terminate = this.errors.terminate();
                    clear();
                    uVar.onError(terminate);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                io.reactivex.internal.queue.a<R> aVar = atomicReference.get();
                Object obj = aVar != null ? (Object) aVar.poll() : (Object) null;
                boolean z2 = obj == null;
                if (z && z2) {
                    Throwable terminate2 = this.errors.terminate();
                    if (terminate2 != null) {
                        uVar.onError(terminate2);
                        return;
                    } else {
                        uVar.onComplete();
                        return;
                    }
                } else if (!z2) {
                    uVar.onNext(obj);
                } else {
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                }
            }
            clear();
        }

        /* loaded from: classes17.dex */
        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<R> {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.m
            public void onSuccess(R r) {
                FlatMapMaybeObserver.this.innerSuccess(this, r);
            }

            @Override // io.reactivex.m
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.innerError(this, th);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                FlatMapMaybeObserver.this.innerComplete(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
