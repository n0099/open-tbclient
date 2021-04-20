package io.reactivex.internal.operators.flowable;

import f.b.w.h;
import f.b.x.f.a;
import f.b.x.i.b;
import g.d.c;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableCombineLatest$CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
    public static final long serialVersionUID = -5082275438355852221L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public final h<? super Object[], ? extends R> combiner;
    public int completedSources;
    public final boolean delayErrors;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public int nonEmptySources;
    public boolean outputFused;
    public final a<Object> queue;
    public final AtomicLong requested;
    public final FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] subscribers;

    public FlowableCombineLatest$CombineLatestCoordinator(c<? super R> cVar, h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
        this.actual = cVar;
        this.combiner = hVar;
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = new FlowableCombineLatest$CombineLatestInnerSubscriber[i];
        for (int i3 = 0; i3 < i; i3++) {
            flowableCombineLatest$CombineLatestInnerSubscriberArr[i3] = new FlowableCombineLatest$CombineLatestInnerSubscriber<>(this, i3, i2);
        }
        this.subscribers = flowableCombineLatest$CombineLatestInnerSubscriberArr;
        this.latest = new Object[i];
        this.queue = new a<>(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
        this.delayErrors = z;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        this.cancelled = true;
        cancelAll();
    }

    public void cancelAll() {
        for (FlowableCombineLatest$CombineLatestInnerSubscriber<T> flowableCombineLatest$CombineLatestInnerSubscriber : this.subscribers) {
            flowableCombineLatest$CombineLatestInnerSubscriber.cancel();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<?> cVar, a<?> aVar) {
        if (this.cancelled) {
            cancelAll();
            aVar.clear();
            return true;
        } else if (z) {
            if (this.delayErrors) {
                if (z2) {
                    cancelAll();
                    Throwable b2 = ExceptionHelper.b(this.error);
                    if (b2 != null && b2 != ExceptionHelper.f69103a) {
                        cVar.onError(b2);
                    } else {
                        cVar.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable b3 = ExceptionHelper.b(this.error);
            if (b3 != null && b3 != ExceptionHelper.f69103a) {
                cancelAll();
                aVar.clear();
                cVar.onError(b3);
                return true;
            } else if (z2) {
                cancelAll();
                cVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainOutput();
        } else {
            drainAsync();
        }
    }

    public void drainAsync() {
        int i;
        c<? super R> cVar = this.actual;
        a<?> aVar = this.queue;
        int i2 = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.done;
                Object poll = aVar.poll();
                boolean z2 = poll == null;
                if (checkTerminated(z, z2, cVar, aVar)) {
                    return;
                }
                if (z2) {
                    break;
                }
                try {
                    Object obj = (R) this.combiner.apply((Object[]) aVar.poll());
                    f.b.x.b.a.b(obj, "The combiner returned a null value");
                    cVar.onNext(obj);
                    ((FlowableCombineLatest$CombineLatestInnerSubscriber) poll).requestOne();
                    j2++;
                } catch (Throwable th) {
                    f.b.u.a.a(th);
                    cancelAll();
                    ExceptionHelper.a(this.error, th);
                    cVar.onError(ExceptionHelper.b(this.error));
                    return;
                }
            }
            if (i == 0 && checkTerminated(this.done, aVar.isEmpty(), cVar, aVar)) {
                return;
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
    }

    public void drainOutput() {
        c<? super R> cVar = this.actual;
        a<Object> aVar = this.queue;
        int i = 1;
        while (!this.cancelled) {
            Throwable th = this.error.get();
            if (th != null) {
                aVar.clear();
                cVar.onError(th);
                return;
            }
            boolean z = this.done;
            boolean isEmpty = aVar.isEmpty();
            if (!isEmpty) {
                cVar.onNext(null);
            }
            if (z && isEmpty) {
                cVar.onComplete();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        aVar.clear();
    }

    public void innerComplete(int i) {
        synchronized (this) {
            Object[] objArr = this.latest;
            if (objArr[i] != null) {
                int i2 = this.completedSources + 1;
                if (i2 == objArr.length) {
                    this.done = true;
                } else {
                    this.completedSources = i2;
                    return;
                }
            } else {
                this.done = true;
            }
            drain();
        }
    }

    public void innerError(int i, Throwable th) {
        if (ExceptionHelper.a(this.error, th)) {
            if (!this.delayErrors) {
                cancelAll();
                this.done = true;
                drain();
                return;
            }
            innerComplete(i);
            return;
        }
        f.b.a0.a.f(th);
    }

    public void innerValue(int i, T t) {
        boolean z;
        synchronized (this) {
            Object[] objArr = this.latest;
            int i2 = this.nonEmptySources;
            if (objArr[i] == null) {
                i2++;
                this.nonEmptySources = i2;
            }
            objArr[i] = t;
            if (objArr.length == i2) {
                this.queue.l(this.subscribers[i], objArr.clone());
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            this.subscribers[i].requestOne();
        } else {
            drain();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public R poll() throws Exception {
        Object poll = this.queue.poll();
        if (poll == null) {
            return null;
        }
        R apply = this.combiner.apply((Object[]) this.queue.poll());
        f.b.x.b.a.b(apply, "The combiner returned a null value");
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) poll).requestOne();
        return apply;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            drain();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.c
    public int requestFusion(int i) {
        if ((i & 4) != 0) {
            return 0;
        }
        int i2 = i & 2;
        this.outputFused = i2 != 0;
        return i2;
    }

    public void subscribe(g.d.b<? extends T>[] bVarArr, int i) {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = this.subscribers;
        for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
            bVarArr[i2].subscribe(flowableCombineLatest$CombineLatestInnerSubscriberArr[i2]);
        }
    }
}
