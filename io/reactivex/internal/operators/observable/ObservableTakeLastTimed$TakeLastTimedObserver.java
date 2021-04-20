package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.p;
import f.b.t.b;
import f.b.x.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableTakeLastTimed$TakeLastTimedObserver<T> extends AtomicBoolean implements o<T>, b {
    public static final long serialVersionUID = -5677354903406201275L;
    public final o<? super T> actual;
    public volatile boolean cancelled;
    public final long count;

    /* renamed from: d  reason: collision with root package name */
    public b f69079d;
    public final boolean delayError;
    public Throwable error;
    public final a<Object> queue;
    public final p scheduler;
    public final long time;
    public final TimeUnit unit;

    public ObservableTakeLastTimed$TakeLastTimedObserver(o<? super T> oVar, long j, long j2, TimeUnit timeUnit, p pVar, int i, boolean z) {
        this.actual = oVar;
        this.count = j;
        this.time = j2;
        this.unit = timeUnit;
        this.scheduler = pVar;
        this.queue = new a<>(i);
        this.delayError = z;
    }

    @Override // f.b.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f69079d.dispose();
        if (compareAndSet(false, true)) {
            this.queue.clear();
        }
    }

    public void drain() {
        Throwable th;
        if (compareAndSet(false, true)) {
            o<? super T> oVar = this.actual;
            a<Object> aVar = this.queue;
            boolean z = this.delayError;
            while (!this.cancelled) {
                if (!z && (th = this.error) != null) {
                    aVar.clear();
                    oVar.onError(th);
                    return;
                }
                Object poll = aVar.poll();
                if (poll == null) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        oVar.onError(th2);
                        return;
                    } else {
                        oVar.onComplete();
                        return;
                    }
                }
                Object poll2 = aVar.poll();
                if (((Long) poll).longValue() >= this.scheduler.b(this.unit) - this.time) {
                    oVar.onNext(poll2);
                }
            }
            aVar.clear();
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.b.o
    public void onComplete() {
        drain();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.error = th;
        drain();
    }

    @Override // f.b.o
    public void onNext(T t) {
        a<Object> aVar = this.queue;
        long b2 = this.scheduler.b(this.unit);
        long j = this.time;
        long j2 = this.count;
        boolean z = j2 == Long.MAX_VALUE;
        aVar.l(Long.valueOf(b2), t);
        while (!aVar.isEmpty()) {
            if (((Long) aVar.peek()).longValue() > b2 - j && (z || (aVar.n() >> 1) <= j2)) {
                return;
            }
            aVar.poll();
            aVar.poll();
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69079d, bVar)) {
            this.f69079d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
