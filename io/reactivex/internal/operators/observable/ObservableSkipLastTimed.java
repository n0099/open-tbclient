package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableSkipLastTimed<T> extends a<T, T> {
    final int bufferSize;
    final boolean delayError;
    final v scheduler;
    final long time;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.subscribe(new SkipLastTimedObserver(uVar, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    /* loaded from: classes7.dex */
    static final class SkipLastTimedObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -5677354903406201275L;
        final u<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        io.reactivex.disposables.b s;
        final v scheduler;
        final long time;
        final TimeUnit unit;

        SkipLastTimedObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v vVar, int i, boolean z) {
            this.actual = uVar;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = vVar;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.delayError = z;
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
            this.queue.offer(Long.valueOf(this.scheduler.a(this.unit)), t);
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
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                u<? super T> uVar = this.actual;
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                boolean z = this.delayError;
                TimeUnit timeUnit = this.unit;
                v vVar = this.scheduler;
                long j = this.time;
                int i = 1;
                while (!this.cancelled) {
                    boolean z2 = this.done;
                    Long l = (Long) aVar.peek();
                    boolean z3 = l == null;
                    long a = vVar.a(timeUnit);
                    if (!z3 && l.longValue() > a - j) {
                        z3 = true;
                    }
                    if (z2) {
                        if (z) {
                            if (z3) {
                                Throwable th = this.error;
                                if (th != null) {
                                    uVar.onError(th);
                                    return;
                                } else {
                                    uVar.onComplete();
                                    return;
                                }
                            }
                        } else {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                this.queue.clear();
                                uVar.onError(th2);
                                return;
                            } else if (z3) {
                                uVar.onComplete();
                                return;
                            }
                        }
                    }
                    if (!z3) {
                        aVar.poll();
                        uVar.onNext(aVar.poll());
                    } else {
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
                this.queue.clear();
            }
        }
    }
}
