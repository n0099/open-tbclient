package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.p;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements g<T>, d {
    public static final long serialVersionUID = -9102637559663639004L;
    public final c<? super T> actual;
    public boolean done;
    public volatile long index;
    public d s;
    public final long timeout;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public final p.c worker;

    public FlowableDebounceTimed$DebounceTimedSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, p.c cVar2) {
        this.actual = cVar;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = cVar2;
    }

    @Override // g.d.d
    public void cancel() {
        this.s.cancel();
        this.worker.dispose();
    }

    public void emit(long j, T t, FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter) {
        if (j == this.index) {
            if (get() != 0) {
                this.actual.onNext(t);
                b.e(this, 1L);
                flowableDebounceTimed$DebounceEmitter.dispose();
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        f.a.t.b bVar = this.timer.get();
        if (DisposableHelper.isDisposed(bVar)) {
            return;
        }
        FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = (FlowableDebounceTimed$DebounceEmitter) bVar;
        if (flowableDebounceTimed$DebounceEmitter != null) {
            flowableDebounceTimed$DebounceEmitter.emit();
        }
        DisposableHelper.dispose(this.timer);
        this.actual.onComplete();
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index + 1;
        this.index = j;
        f.a.t.b bVar = this.timer.get();
        if (bVar != null) {
            bVar.dispose();
        }
        FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = new FlowableDebounceTimed$DebounceEmitter(t, j, this);
        if (this.timer.replace(flowableDebounceTimed$DebounceEmitter)) {
            flowableDebounceTimed$DebounceEmitter.setResource(this.worker.c(flowableDebounceTimed$DebounceEmitter, this.timeout, this.unit));
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this, j);
        }
    }
}
