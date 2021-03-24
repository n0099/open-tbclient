package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.p;
import f.a.x.c.f;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public abstract class FlowableObserveOn$BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements g<T>, Runnable {
    public static final long serialVersionUID = -8241002408341274697L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public boolean outputFused;
    public final int prefetch;
    public long produced;
    public f<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public d s;
    public int sourceMode;
    public final p.c worker;

    public FlowableObserveOn$BaseObserveOnSubscriber(p.c cVar, boolean z, int i) {
        this.worker = cVar;
        this.delayError = z;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public final void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public final boolean checkTerminated(boolean z, boolean z2, c<?> cVar) {
        if (this.cancelled) {
            clear();
            return true;
        } else if (z) {
            if (this.delayError) {
                if (z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                clear();
                cVar.onError(th2);
                this.worker.dispose();
                return true;
            } else if (z2) {
                cVar.onComplete();
                this.worker.dispose();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public final void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // g.d.c
    public final void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        trySchedule();
    }

    @Override // g.d.c
    public final void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.error = th;
        this.done = true;
        trySchedule();
    }

    @Override // g.d.c
    public final void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 2) {
            trySchedule();
            return;
        }
        if (!this.queue.offer(t)) {
            this.s.cancel();
            this.error = new MissingBackpressureException("Queue is full?!");
            this.done = true;
        }
        trySchedule();
    }

    @Override // f.a.g, g.d.c
    public abstract /* synthetic */ void onSubscribe(d dVar);

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            trySchedule();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.c
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.outputFused) {
            runBackfused();
        } else if (this.sourceMode == 1) {
            runSync();
        } else {
            runAsync();
        }
    }

    public abstract void runAsync();

    public abstract void runBackfused();

    public abstract void runSync();

    public final void trySchedule() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.worker.b(this);
    }
}
