package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.p;
import f.a.t.b;
import f.a.x.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableSkipLastTimed$SkipLastTimedObserver<T> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = -5677354903406201275L;
    public final o<? super T> actual;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a<Object> queue;
    public b s;
    public final p scheduler;
    public final long time;
    public final TimeUnit unit;

    public ObservableSkipLastTimed$SkipLastTimedObserver(o<? super T> oVar, long j, TimeUnit timeUnit, p pVar, int i, boolean z) {
        this.actual = oVar;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = pVar;
        this.queue = new a<>(i);
        this.delayError = z;
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        o<? super T> oVar = this.actual;
        a<Object> aVar = this.queue;
        boolean z = this.delayError;
        TimeUnit timeUnit = this.unit;
        p pVar = this.scheduler;
        long j = this.time;
        int i = 1;
        while (!this.cancelled) {
            boolean z2 = this.done;
            Long l = (Long) aVar.peek();
            boolean z3 = l == null;
            long b2 = pVar.b(timeUnit);
            if (!z3 && l.longValue() > b2 - j) {
                z3 = true;
            }
            if (z2) {
                if (!z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        oVar.onError(th);
                        return;
                    } else if (z3) {
                        oVar.onComplete();
                        return;
                    }
                } else if (z3) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        oVar.onError(th2);
                        return;
                    } else {
                        oVar.onComplete();
                        return;
                    }
                }
            }
            if (z3) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                aVar.poll();
                oVar.onNext(aVar.poll());
            }
        }
        this.queue.clear();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.a.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.queue.l(Long.valueOf(this.scheduler.b(this.unit)), t);
        drain();
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
