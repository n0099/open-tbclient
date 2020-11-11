package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes17.dex */
public final class FlowableSkipLastTimed<T> extends a<T, T> {
    final int bufferSize;
    final boolean delayError;
    final v scheduler;
    final long time;
    final TimeUnit unit;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.pMK.a((j) new SkipLastTimedSubscriber(cVar, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    /* loaded from: classes17.dex */
    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -5677354903406201275L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested = new AtomicLong();
        org.a.d s;
        final v scheduler;
        final long time;
        final TimeUnit unit;

        SkipLastTimedSubscriber(org.a.c<? super T> cVar, long j, TimeUnit timeUnit, v vVar, int i, boolean z) {
            this.actual = cVar;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = vVar;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.delayError = z;
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
            this.queue.offer(Long.valueOf(this.scheduler.a(this.unit)), t);
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
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
            long j;
            if (getAndIncrement() == 0) {
                int i = 1;
                org.a.c<? super T> cVar = this.actual;
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                boolean z = this.delayError;
                TimeUnit timeUnit = this.unit;
                v vVar = this.scheduler;
                long j2 = this.time;
                while (true) {
                    int i2 = i;
                    long j3 = this.requested.get();
                    long j4 = 0;
                    while (true) {
                        j = j4;
                        if (j == j3) {
                            break;
                        }
                        boolean z2 = this.done;
                        Long l = (Long) aVar.peek();
                        boolean z3 = l == null;
                        long a2 = vVar.a(timeUnit);
                        if (!z3 && l.longValue() > a2 - j2) {
                            z3 = true;
                        }
                        if (!checkTerminated(z2, z3, cVar, z)) {
                            if (z3) {
                                break;
                            }
                            aVar.poll();
                            cVar.onNext(aVar.poll());
                            j4 = 1 + j;
                        } else {
                            return;
                        }
                    }
                    if (j != 0) {
                        io.reactivex.internal.util.b.c(this.requested, j);
                    }
                    i = addAndGet(-i2);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<? super T> cVar, boolean z3) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (z3) {
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
    }
}
