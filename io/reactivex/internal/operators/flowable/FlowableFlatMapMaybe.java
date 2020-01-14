package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class FlowableFlatMapMaybe<T, R> extends a<T, R> {
    final boolean delayErrors;
    final h<? super T, ? extends o<? extends R>> mapper;
    final int maxConcurrency;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        this.nvP.a((j) new FlatMapMaybeSubscriber(cVar, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    /* loaded from: classes5.dex */
    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = 8600231336733376951L;
        final org.a.c<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final h<? super T, ? extends o<? extends R>> mapper;
        final int maxConcurrency;
        org.a.d s;
        final AtomicLong requested = new AtomicLong();
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<io.reactivex.internal.queue.a<R>> queue = new AtomicReference<>();

        FlatMapMaybeSubscriber(org.a.c<? super R> cVar, h<? super T, ? extends o<? extends R>> hVar, boolean z, int i) {
            this.actual = cVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
                } else {
                    dVar.request(this.maxConcurrency);
                }
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            try {
                o oVar = (o) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.cancelled && this.set.a(innerObserver)) {
                    oVar.a(innerObserver);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // org.a.c
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

        @Override // org.a.c
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        void innerSuccess(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
            this.set.c(innerObserver);
            if (get() == 0 && compareAndSet(0, 1)) {
                boolean z = this.active.decrementAndGet() == 0;
                if (this.requested.get() != 0) {
                    this.actual.onNext(r);
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
                    }
                    io.reactivex.internal.util.b.c(this.requested, 1L);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                    }
                } else {
                    io.reactivex.internal.queue.a<R> orCreateQueue = getOrCreateQueue();
                    synchronized (orCreateQueue) {
                        orCreateQueue.offer(r);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.internal.queue.a<R> orCreateQueue2 = getOrCreateQueue();
                synchronized (orCreateQueue2) {
                    orCreateQueue2.offer(r);
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
                aVar = new io.reactivex.internal.queue.a<>(io.reactivex.g.dHT());
            } while (!this.queue.compareAndSet(null, aVar));
            return aVar;
        }

        void innerError(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.s.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
                this.active.decrementAndGet();
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
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
                }
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
                if (decrementAndGet() != 0) {
                    drainLoop();
                    return;
                }
                return;
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
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

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
            if (r4 != r10) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0074, code lost:
            if (r12.cancelled == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
            if (r12.delayErrors != false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x008e, code lost:
            if (r12.errors.get() == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
            r0 = r12.errors.terminate();
            clear();
            r6.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a1, code lost:
            if (r7.get() != 0) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a3, code lost:
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
            r0 = r8.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
            if (r0 == null) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00b1, code lost:
            if (r0.isEmpty() == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b3, code lost:
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b4, code lost:
            if (r2 == false) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
            if (r0 == false) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
            r0 = r12.errors.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00be, code lost:
            if (r0 == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00c0, code lost:
            r6.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00c5, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00c8, code lost:
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ca, code lost:
            r6.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
            if (r4 == 0) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00d5, code lost:
            io.reactivex.internal.util.b.c(r12.requested, r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00df, code lost:
            if (r12.maxConcurrency == Integer.MAX_VALUE) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00e1, code lost:
            r12.s.request(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00e6, code lost:
            r0 = addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00eb, code lost:
            if (r0 == 0) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            int i = 1;
            org.a.c<? super R> cVar = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<io.reactivex.internal.queue.a<R>> atomicReference = this.queue;
            while (true) {
                int i2 = i;
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    long j3 = j2;
                    if (j3 == j) {
                        break;
                    } else if (this.cancelled) {
                        clear();
                        return;
                    } else if (!this.delayErrors && this.errors.get() != null) {
                        Throwable terminate = this.errors.terminate();
                        clear();
                        cVar.onError(terminate);
                        return;
                    } else {
                        boolean z = atomicInteger.get() == 0;
                        io.reactivex.internal.queue.a<R> aVar = atomicReference.get();
                        Object obj = aVar != null ? (Object) aVar.poll() : (Object) null;
                        boolean z2 = obj == null;
                        if (z && z2) {
                            Throwable terminate2 = this.errors.terminate();
                            if (terminate2 != null) {
                                cVar.onError(terminate2);
                                return;
                            } else {
                                cVar.onComplete();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            cVar.onNext(obj);
                            j2 = 1 + j3;
                        }
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
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
                FlatMapMaybeSubscriber.this.innerSuccess(this, r);
            }

            @Override // io.reactivex.m
            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.innerError(this, th);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                FlatMapMaybeSubscriber.this.innerComplete(this);
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
