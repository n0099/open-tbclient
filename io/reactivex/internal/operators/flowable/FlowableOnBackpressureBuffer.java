package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {
    final int bufferSize;
    final boolean delayError;
    final io.reactivex.c.a onOverflow;
    final boolean unbounded;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nJW.a((j) new BackpressureBufferSubscriber(cVar, this.bufferSize, this.unbounded, this.delayError, this.onOverflow));
    }

    /* loaded from: classes7.dex */
    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements j<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final io.reactivex.c.a onOverflow;
        boolean outputFused;
        final io.reactivex.internal.a.f<T> queue;
        final AtomicLong requested = new AtomicLong();
        org.a.d s;

        BackpressureBufferSubscriber(org.a.c<? super T> cVar, int i, boolean z, boolean z2, io.reactivex.c.a aVar) {
            io.reactivex.internal.a.f<T> spscArrayQueue;
            this.actual = cVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            if (z) {
                spscArrayQueue = new io.reactivex.internal.queue.a<>(i);
            } else {
                spscArrayQueue = new SpscArrayQueue<>(i);
            }
            this.queue = spscArrayQueue;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.queue.offer(t)) {
                this.s.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.onOverflow.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.L(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
            } else if (this.outputFused) {
                this.actual.onNext(null);
            } else {
                drain();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (!this.outputFused && SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.a.f<T> fVar = this.queue;
                org.a.c<? super T> cVar = this.actual;
                int i = 1;
                while (!checkTerminated(this.done, fVar.isEmpty(), cVar)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        Object obj = (T) fVar.poll();
                        boolean z2 = obj == null;
                        if (!checkTerminated(z, z2, cVar)) {
                            if (z2) {
                                break;
                            }
                            cVar.onNext(obj);
                            j2 = 1 + j2;
                        } else {
                            return;
                        }
                    }
                    if (j2 != j || !checkTerminated(this.done, fVar.isEmpty(), cVar)) {
                        if (j2 != 0 && j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<? super T> cVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (this.delayError) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            cVar.onError(th);
                            return true;
                        }
                        cVar.onComplete();
                        return true;
                    }
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        cVar.onError(th2);
                        return true;
                    } else if (z2) {
                        cVar.onComplete();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }
}
