package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.a.d;
/* loaded from: classes3.dex */
public final class FlowableTakeLastTimed<T> extends a<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final v scheduler;
    final long time;
    final TimeUnit unit;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.qgK.a((j) new TakeLastTimedSubscriber(cVar, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    /* loaded from: classes3.dex */
    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements j<T>, d {
        private static final long serialVersionUID = -5677354903406201275L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested = new AtomicLong();
        d s;
        final v scheduler;
        final long time;
        final TimeUnit unit;

        TakeLastTimedSubscriber(org.a.c<? super T> cVar, long j, long j2, TimeUnit timeUnit, v vVar, int i, boolean z) {
            this.actual = cVar;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = vVar;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.delayError = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            long a2 = this.scheduler.a(this.unit);
            aVar.offer(Long.valueOf(a2), t);
            trim(a2, aVar);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.a(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            trim(this.scheduler.a(this.unit), this.queue);
            this.done = true;
            drain();
        }

        void trim(long j, io.reactivex.internal.queue.a<Object> aVar) {
            long j2 = this.time;
            long j3 = this.count;
            boolean z = j3 == Long.MAX_VALUE;
            while (!aVar.isEmpty()) {
                if (((Long) aVar.peek()).longValue() < j - j2 || (!z && (aVar.size() >> 1) > j3)) {
                    aVar.poll();
                    aVar.poll();
                } else {
                    return;
                }
            }
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
            if (getAndIncrement() == 0) {
                org.a.c<? super T> cVar = this.actual;
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                boolean z = this.delayError;
                int i = 1;
                do {
                    if (this.done) {
                        if (!checkTerminated(aVar.isEmpty(), cVar, z)) {
                            long j = this.requested.get();
                            long j2 = 0;
                            while (true) {
                                if (!checkTerminated(aVar.peek() == null, cVar, z)) {
                                    if (j != j2) {
                                        aVar.poll();
                                        cVar.onNext(aVar.poll());
                                        j2++;
                                    } else if (j2 != 0) {
                                        io.reactivex.internal.util.b.c(this.requested, j2);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        boolean checkTerminated(boolean z, org.a.c<? super T> cVar, boolean z2) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z2) {
                if (z) {
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
                } else if (z) {
                    cVar.onComplete();
                    return true;
                }
            }
            return false;
        }
    }
}
