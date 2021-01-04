package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class ObservableTakeLastTimed<T> extends a<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final v scheduler;
    final long time;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.subscribe(new TakeLastTimedObserver(uVar, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    /* loaded from: classes3.dex */
    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -5677354903406201275L;
        final u<? super T> actual;
        volatile boolean cancelled;
        final long count;
        io.reactivex.disposables.b d;
        final boolean delayError;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final v scheduler;
        final long time;
        final TimeUnit unit;

        TakeLastTimedObserver(u<? super T> uVar, long j, long j2, TimeUnit timeUnit, v vVar, int i, boolean z) {
            this.actual = uVar;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = vVar;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.delayError = z;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            long a2 = this.scheduler.a(this.unit);
            long j = this.time;
            long j2 = this.count;
            boolean z = j2 == Long.MAX_VALUE;
            aVar.offer(Long.valueOf(a2), t);
            while (!aVar.isEmpty()) {
                if (((Long) aVar.peek()).longValue() <= a2 - j || (!z && (aVar.size() >> 1) > j2)) {
                    aVar.poll();
                    aVar.poll();
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.error = th;
            drain();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.d.dispose();
                if (compareAndSet(false, true)) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                u<? super T> uVar = this.actual;
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                boolean z = this.delayError;
                while (!this.cancelled) {
                    if (!z && (th = this.error) != null) {
                        aVar.clear();
                        uVar.onError(th);
                        return;
                    }
                    Object poll = aVar.poll();
                    if (poll == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            uVar.onError(th2);
                            return;
                        } else {
                            uVar.onComplete();
                            return;
                        }
                    }
                    Object poll2 = aVar.poll();
                    if (((Long) poll).longValue() >= this.scheduler.a(this.unit) - this.time) {
                        uVar.onNext(poll2);
                    }
                }
                aVar.clear();
            }
        }
    }
}
