package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableSampleTimed<T> extends a<T, T> {
    final boolean ons;
    final long period;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        io.reactivex.observers.b bVar = new io.reactivex.observers.b(uVar);
        if (this.ons) {
            this.source.subscribe(new SampleTimedEmitLast(bVar, this.period, this.unit, this.scheduler));
        } else {
            this.source.subscribe(new SampleTimedNoLast(bVar, this.period, this.unit, this.scheduler));
        }
    }

    /* loaded from: classes7.dex */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements io.reactivex.disposables.b, u<T>, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final u<? super T> actual;
        final long period;
        io.reactivex.disposables.b s;
        final v scheduler;
        final AtomicReference<io.reactivex.disposables.b> timer = new AtomicReference<>();
        final TimeUnit unit;

        abstract void complete();

        SampleTimedObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v vVar) {
            this.actual = uVar;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
                DisposableHelper.replace(this.timer, this.scheduler.a(this, this.period, this.period, this.unit));
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            cancelTimer();
            complete();
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            cancelTimer();
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(u<? super T> uVar, long j, TimeUnit timeUnit, v vVar) {
            super(uVar, j, timeUnit, vVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* loaded from: classes7.dex */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(u<? super T> uVar, long j, TimeUnit timeUnit, v vVar) {
            super(uVar, j, timeUnit, vVar);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }
}
