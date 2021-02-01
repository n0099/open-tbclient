package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableDebounceTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.subscribe(new a(new io.reactivex.observers.b(uVar), this.timeout, this.unit, this.scheduler.eKi()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> implements io.reactivex.disposables.b, u<T> {
        final u<? super T> actual;
        boolean done;
        volatile long index;
        io.reactivex.disposables.b s;
        final long timeout;
        final AtomicReference<io.reactivex.disposables.b> timer = new AtomicReference<>();
        final TimeUnit unit;
        final v.c worker;

        a(u<? super T> uVar, long j, TimeUnit timeUnit, v.c cVar) {
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
            if (!this.done) {
                long j = 1 + this.index;
                this.index = j;
                io.reactivex.disposables.b bVar = this.timer.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
                if (this.timer.compareAndSet(bVar, debounceEmitter)) {
                    debounceEmitter.setResource(this.worker.c(debounceEmitter, this.timeout, this.unit));
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
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
                io.reactivex.disposables.b bVar = this.timer.get();
                if (bVar != DisposableHelper.DISPOSED) {
                    DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
                    if (debounceEmitter != null) {
                        debounceEmitter.run();
                    }
                    this.actual.onComplete();
                    this.worker.dispose();
                }
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

        void a(long j, T t, DebounceEmitter<T> debounceEmitter) {
            if (j == this.index) {
                this.actual.onNext(t);
                debounceEmitter.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final a<T> parent;
        final T value;

        DebounceEmitter(T t, long j, a<T> aVar) {
            this.value = t;
            this.idx = j;
            this.parent = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }
}
