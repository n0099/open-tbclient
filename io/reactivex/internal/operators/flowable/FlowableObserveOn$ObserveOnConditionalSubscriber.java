package io.reactivex.internal.operators.flowable;

import f.a.p;
import f.a.x.c.a;
import f.a.x.c.f;
import g.d.d;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableObserveOn$ObserveOnConditionalSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    public static final long serialVersionUID = 644624475404284533L;
    public final a<? super T> actual;
    public long consumed;

    public FlowableObserveOn$ObserveOnConditionalSubscriber(a<? super T> aVar, p.c cVar, boolean z, int i) {
        super(cVar, z, i);
        this.actual = aVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof f.a.x.c.d) {
                f.a.x.c.d dVar2 = (f.a.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = 1;
                    this.queue = dVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = 2;
                    this.queue = dVar2;
                    this.actual.onSubscribe(this);
                    dVar.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            this.actual.onSubscribe(this);
            dVar.request(this.prefetch);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public T poll() throws Exception {
        T poll = this.queue.poll();
        if (poll != null && this.sourceMode != 1) {
            long j = this.consumed + 1;
            if (j == this.limit) {
                this.consumed = 0L;
                this.s.request(j);
            } else {
                this.consumed = j;
            }
        }
        return poll;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runAsync() {
        int i;
        a<? super T> aVar = this.actual;
        f<T> fVar = this.queue;
        long j = this.produced;
        long j2 = this.consumed;
        int i2 = 1;
        while (true) {
            long j3 = this.requested.get();
            while (true) {
                i = (j > j3 ? 1 : (j == j3 ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.done;
                try {
                    Object obj = (T) fVar.poll();
                    boolean z2 = obj == null;
                    if (checkTerminated(z, z2, aVar)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    if (aVar.tryOnNext(obj)) {
                        j++;
                    }
                    j2++;
                    if (j2 == this.limit) {
                        this.s.request(j2);
                        j2 = 0;
                    }
                } catch (Throwable th) {
                    f.a.u.a.a(th);
                    this.s.cancel();
                    fVar.clear();
                    aVar.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
            if (i == 0 && checkTerminated(this.done, fVar.isEmpty(), aVar)) {
                return;
            }
            int i3 = get();
            if (i2 == i3) {
                this.produced = j;
                this.consumed = j2;
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                i2 = i3;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runBackfused() {
        int i = 1;
        while (!this.cancelled) {
            boolean z = this.done;
            this.actual.onNext(null);
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
                this.worker.dispose();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runSync() {
        a<? super T> aVar = this.actual;
        f<T> fVar = this.queue;
        long j = this.produced;
        int i = 1;
        while (true) {
            long j2 = this.requested.get();
            while (j != j2) {
                try {
                    Object obj = (T) fVar.poll();
                    if (this.cancelled) {
                        return;
                    }
                    if (obj == null) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (aVar.tryOnNext(obj)) {
                        j++;
                    }
                } catch (Throwable th) {
                    f.a.u.a.a(th);
                    this.s.cancel();
                    aVar.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
            if (this.cancelled) {
                return;
            }
            if (fVar.isEmpty()) {
                aVar.onComplete();
                this.worker.dispose();
                return;
            }
            int i2 = get();
            if (i == i2) {
                this.produced = j;
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                i = i2;
            }
        }
    }
}
