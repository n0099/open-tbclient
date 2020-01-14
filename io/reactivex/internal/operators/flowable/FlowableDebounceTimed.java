package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class FlowableDebounceTimed<T> extends a<T, T> {
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nvP.a((j) new DebounceTimedSubscriber(new io.reactivex.subscribers.b(cVar), this.timeout, this.unit, this.scheduler.dHY()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements j<T>, org.a.d {
        private static final long serialVersionUID = -9102637559663639004L;
        final org.a.c<? super T> actual;
        boolean done;
        volatile long index;
        org.a.d s;
        final long timeout;
        io.reactivex.disposables.b timer;
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
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                io.reactivex.disposables.b bVar = this.timer;
                if (bVar != null) {
                    bVar.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
                this.timer = debounceEmitter;
                debounceEmitter.setResource(this.worker.c(debounceEmitter, this.timeout, this.unit));
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            io.reactivex.disposables.b bVar = this.timer;
            if (bVar != null) {
                bVar.dispose();
            }
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                io.reactivex.disposables.b bVar = this.timer;
                if (bVar != null) {
                    bVar.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
                if (debounceEmitter != null) {
                    debounceEmitter.emit();
                }
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

        void emit(long j, T t, DebounceEmitter<T> debounceEmitter) {
            if (j == this.index) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    io.reactivex.internal.util.b.c(this, 1L);
                    debounceEmitter.dispose();
                    return;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final DebounceTimedSubscriber<T> parent;
        final T value;

        DebounceEmitter(T t, long j, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.value = t;
            this.idx = j;
            this.parent = debounceTimedSubscriber;
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }

        void emit() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.emit(this.idx, this.value, this);
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
