package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.f;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class ObservableTimeoutTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    static final io.reactivex.disposables.b oyz = new a();
    final t<? extends T> other;
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        if (this.other == null) {
            this.source.subscribe(new TimeoutTimedObserver(new io.reactivex.observers.b(uVar), this.timeout, this.unit, this.scheduler.eja()));
        } else {
            this.source.subscribe(new TimeoutTimedOtherObserver(uVar, this.timeout, this.unit, this.scheduler.eja(), this.other));
        }
    }

    /* loaded from: classes25.dex */
    static final class TimeoutTimedOtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -4619702551964128179L;
        final u<? super T> actual;
        final f<T> arbiter;
        volatile boolean done;
        volatile long index;
        final t<? extends T> other;
        io.reactivex.disposables.b s;
        final long timeout;
        final TimeUnit unit;
        final v.c worker;

        TimeoutTimedOtherObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v.c cVar, t<? extends T> tVar) {
            this.actual = uVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.other = tVar;
            this.arbiter = new f<>(uVar, this, 8);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                if (this.arbiter.d(bVar)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                if (this.arbiter.a((f<T>) t, this.s)) {
                    scheduleTimeout(j);
                }
            }
        }

        void scheduleTimeout(long j) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            if (compareAndSet(bVar, ObservableTimeoutTimed.oyz)) {
                DisposableHelper.replace(this, this.worker.c(new a(j), this.timeout, this.unit));
            }
        }

        void subscribeNext() {
            this.other.subscribe(new io.reactivex.internal.observers.b(this.arbiter));
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.arbiter.a(th, this.s);
            this.worker.dispose();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.arbiter.e(this.s);
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes25.dex */
        public final class a implements Runnable {
            private final long idx;

            a(long j) {
                this.idx = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.idx == TimeoutTimedOtherObserver.this.index) {
                    TimeoutTimedOtherObserver.this.done = true;
                    TimeoutTimedOtherObserver.this.s.dispose();
                    DisposableHelper.dispose(TimeoutTimedOtherObserver.this);
                    TimeoutTimedOtherObserver.this.subscribeNext();
                    TimeoutTimedOtherObserver.this.worker.dispose();
                }
            }
        }
    }

    /* loaded from: classes25.dex */
    static final class TimeoutTimedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -8387234228317808253L;
        final u<? super T> actual;
        volatile boolean done;
        volatile long index;
        io.reactivex.disposables.b s;
        final long timeout;
        final TimeUnit unit;
        final v.c worker;

        TimeoutTimedObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v.c cVar) {
            this.actual = uVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                this.actual.onNext(t);
                scheduleTimeout(j);
            }
        }

        void scheduleTimeout(long j) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            if (compareAndSet(bVar, ObservableTimeoutTimed.oyz)) {
                DisposableHelper.replace(this, this.worker.c(new a(j), this.timeout, this.unit));
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            dispose();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
                dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes25.dex */
        public final class a implements Runnable {
            private final long idx;

            a(long j) {
                this.idx = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.idx == TimeoutTimedObserver.this.index) {
                    TimeoutTimedObserver.this.done = true;
                    TimeoutTimedObserver.this.s.dispose();
                    DisposableHelper.dispose(TimeoutTimedObserver.this);
                    TimeoutTimedObserver.this.actual.onError(new TimeoutException());
                    TimeoutTimedObserver.this.worker.dispose();
                }
            }
        }
    }

    /* loaded from: classes25.dex */
    static final class a implements io.reactivex.disposables.b {
        a() {
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return true;
        }
    }
}
