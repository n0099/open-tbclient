package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableThrottleLatest<T> extends a<T, T> {
    final boolean emitLast;
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nwt.a((j) new ThrottleLatestSubscriber(cVar, this.timeout, this.unit, this.scheduler.dJh(), this.emitLast));
    }

    /* loaded from: classes7.dex */
    static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final org.a.c<? super T> downstream;
        final boolean emitLast;
        long emitted;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        org.a.d upstream;
        final v.c worker;

        ThrottleLatestSubscriber(org.a.c<? super T> cVar, long j, TimeUnit timeUnit, v.c cVar2, boolean z) {
            this.downstream = cVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar2;
            this.emitLast = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.latest.set(t);
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
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                int i = 1;
                AtomicReference<T> atomicReference = this.latest;
                AtomicLong atomicLong = this.requested;
                org.a.c<? super T> cVar = this.downstream;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && this.error != null) {
                        atomicReference.lazySet(null);
                        cVar.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        if (!z2 && this.emitLast) {
                            T andSet = atomicReference.getAndSet(null);
                            long j = this.emitted;
                            if (j != atomicLong.get()) {
                                this.emitted = 1 + j;
                                cVar.onNext(andSet);
                                cVar.onComplete();
                            } else {
                                cVar.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                            }
                        } else {
                            atomicReference.lazySet(null);
                            cVar.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    if (z2) {
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                    } else if (!this.timerRunning || this.timerFired) {
                        T andSet2 = atomicReference.getAndSet(null);
                        long j2 = this.emitted;
                        if (j2 != atomicLong.get()) {
                            cVar.onNext(andSet2);
                            this.emitted = j2 + 1;
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.c(this, this.timeout, this.unit);
                        } else {
                            this.upstream.cancel();
                            cVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                            this.worker.dispose();
                            return;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                atomicReference.lazySet(null);
            }
        }
    }
}
