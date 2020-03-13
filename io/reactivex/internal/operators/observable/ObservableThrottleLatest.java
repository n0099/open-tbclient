package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableThrottleLatest<T> extends a<T, T> {
    final boolean emitLast;
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.source.subscribe(new ThrottleLatestObserver(uVar, this.timeout, this.unit, this.scheduler.dJi(), this.emitLast));
    }

    /* loaded from: classes7.dex */
    static final class ThrottleLatestObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, u<T>, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final u<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;
        final v.c worker;

        ThrottleLatestObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v.c cVar, boolean z) {
            this.downstream = uVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.emitLast = z;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.latest.set(t);
            drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                u<? super T> uVar = this.downstream;
                int i = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && this.error != null) {
                        atomicReference.lazySet(null);
                        uVar.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        T andSet = atomicReference.getAndSet(null);
                        if (!z2 && this.emitLast) {
                            uVar.onNext(andSet);
                        }
                        uVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    if (z2) {
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                    } else if (!this.timerRunning || this.timerFired) {
                        uVar.onNext(atomicReference.getAndSet(null));
                        this.timerFired = false;
                        this.timerRunning = true;
                        this.worker.c(this, this.timeout, this.unit);
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
