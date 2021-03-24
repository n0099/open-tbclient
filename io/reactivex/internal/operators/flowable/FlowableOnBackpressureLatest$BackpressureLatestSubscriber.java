package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureLatest$BackpressureLatestSubscriber<T> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = 163080509307634843L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public d s;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<T> current = new AtomicReference<>();

    public FlowableOnBackpressureLatest$BackpressureLatestSubscriber(c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
            this.current.lazySet(null);
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<?> cVar, AtomicReference<T> atomicReference) {
        if (this.cancelled) {
            atomicReference.lazySet(null);
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (th != null) {
                atomicReference.lazySet(null);
                cVar.onError(th);
                return true;
            } else if (z2) {
                cVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.actual;
        AtomicLong atomicLong = this.requested;
        AtomicReference<T> atomicReference = this.current;
        int i = 1;
        do {
            long j = 0;
            while (true) {
                if (j == atomicLong.get()) {
                    break;
                }
                boolean z = this.done;
                Object obj = (T) atomicReference.getAndSet(null);
                boolean z2 = obj == null;
                if (checkTerminated(z, z2, cVar, atomicReference)) {
                    return;
                }
                if (z2) {
                    break;
                }
                cVar.onNext(obj);
                j++;
            }
            if (j == atomicLong.get()) {
                if (checkTerminated(this.done, atomicReference.get() == null, cVar, atomicReference)) {
                    return;
                }
            }
            if (j != 0) {
                b.e(atomicLong, j);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.current.lazySet(t);
        drain();
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
            b.a(this.requested, j);
            drain();
        }
    }
}
