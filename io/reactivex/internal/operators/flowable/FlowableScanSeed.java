package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableScanSeed<T, R> extends a<T, R> {
    final io.reactivex.c.c<R, ? super T, R> accumulator;
    final Callable<R> onM;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super R> cVar) {
        try {
            this.omT.a((j) new ScanSeedSubscriber(cVar, this.accumulator, io.reactivex.internal.functions.a.k(this.onM.call(), "The seed supplied is null"), eeY()));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements j<T>, org.b.d {
        private static final long serialVersionUID = -1776795561228106469L;
        final io.reactivex.c.c<R, ? super T, R> accumulator;
        final org.b.c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final io.reactivex.internal.a.f<R> queue;
        final AtomicLong requested;
        org.b.d s;
        R value;

        ScanSeedSubscriber(org.b.c<? super R> cVar, io.reactivex.c.c<R, ? super T, R> cVar2, R r, int i) {
            this.actual = cVar;
            this.accumulator = cVar2;
            this.value = r;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.queue = new SpscArrayQueue(i);
            this.queue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch - 1);
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            if (!this.done) {
                try {
                    R r = (R) io.reactivex.internal.functions.a.k(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                    this.value = r;
                    this.queue.offer(r);
                    drain();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.b.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // org.b.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
            if (r4 != r10) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
            if (r14.done == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
            r2 = r14.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
            if (r2 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
            r7.clear();
            r6.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
            if (r7.isEmpty() == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
            r6.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
            if (r4 == 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
            io.reactivex.internal.util.b.c(r14.requested, r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0082, code lost:
            r14.consumed = r0;
            r1 = addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            Throwable th;
            if (getAndIncrement() == 0) {
                int i = 1;
                org.b.c<? super R> cVar = this.actual;
                io.reactivex.internal.a.f<R> fVar = this.queue;
                int i2 = this.limit;
                int i3 = this.consumed;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        long j3 = j2;
                        if (j3 == j) {
                            break;
                        } else if (this.cancelled) {
                            fVar.clear();
                            return;
                        } else {
                            boolean z = this.done;
                            if (z && (th = this.error) != null) {
                                fVar.clear();
                                cVar.onError(th);
                                return;
                            }
                            Object obj = (R) fVar.poll();
                            boolean z2 = obj == null;
                            if (z && z2) {
                                cVar.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                cVar.onNext(obj);
                                j2 = 1 + j3;
                                i3++;
                                if (i3 == i2) {
                                    i3 = 0;
                                    this.s.request(i2);
                                }
                            }
                        }
                    }
                } while (i != 0);
            }
        }
    }
}
