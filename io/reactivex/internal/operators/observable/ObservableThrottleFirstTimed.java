package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableThrottleFirstTimed<T> extends a<T, T> {
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.subscribe(new DebounceTimedObserver(new io.reactivex.observers.b(uVar), this.timeout, this.unit, this.scheduler.dJh()));
    }

    /* loaded from: classes7.dex */
    static final class DebounceTimedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T>, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        final u<? super T> actual;
        boolean done;
        volatile boolean gate;
        io.reactivex.disposables.b s;
        final long timeout;
        final TimeUnit unit;
        final v.c worker;

        DebounceTimedObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v.c cVar) {
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
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.gate && !this.done) {
                this.gate = true;
                this.actual.onNext(t);
                io.reactivex.disposables.b bVar = get();
                if (bVar != null) {
                    bVar.dispose();
                }
                DisposableHelper.replace(this, this.worker.c(this, this.timeout, this.unit));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
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
    }
}
