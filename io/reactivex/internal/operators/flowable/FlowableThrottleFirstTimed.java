package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class FlowableThrottleFirstTimed<T> extends a<T, T> {
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nvK.a((j) new DebounceTimedSubscriber(new io.reactivex.subscribers.b(cVar), this.timeout, this.unit, this.scheduler.dHW()));
    }

    /* loaded from: classes5.dex */
    static final class DebounceTimedSubscriber<T> extends AtomicLong implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -9102637559663639004L;
        final org.a.c<? super T> actual;
        boolean done;
        volatile boolean gate;
        org.a.d s;
        final long timeout;
        final SequentialDisposable timer = new SequentialDisposable();
        final TimeUnit unit;
        final v.c worker;

        DebounceTimedSubscriber(org.a.c<? super T> cVar, long j, TimeUnit timeUnit, v.c cVar2) {
            this.actual = cVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done && !this.gate) {
                this.gate = true;
                if (get() != 0) {
                    this.actual.onNext(t);
                    io.reactivex.internal.util.b.c(this, 1L);
                    io.reactivex.disposables.b bVar = this.timer.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.timer.replace(this.worker.c(this, this.timeout, this.unit));
                    return;
                }
                this.done = true;
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
            this.worker.dispose();
        }
    }
}
