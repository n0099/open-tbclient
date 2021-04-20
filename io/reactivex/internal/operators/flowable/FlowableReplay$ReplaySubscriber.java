package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.t.b;
import f.b.x.e.a.j;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableReplay$ReplaySubscriber<T> extends AtomicReference<d> implements g<T>, b {
    public static final FlowableReplay$InnerSubscription[] EMPTY = new FlowableReplay$InnerSubscription[0];
    public static final FlowableReplay$InnerSubscription[] TERMINATED = new FlowableReplay$InnerSubscription[0];
    public static final long serialVersionUID = 7224554242710036740L;
    public final j<T> buffer;
    public boolean done;
    public long maxChildRequested;
    public long maxUpstreamRequested;
    public final AtomicInteger management = new AtomicInteger();
    public final AtomicReference<FlowableReplay$InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    public final AtomicBoolean shouldConnect = new AtomicBoolean();

    public FlowableReplay$ReplaySubscriber(j<T> jVar) {
        this.buffer = jVar;
    }

    public boolean add(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription<T>[] flowableReplay$InnerSubscriptionArr;
        FlowableReplay$InnerSubscription<T>[] flowableReplay$InnerSubscriptionArr2;
        if (flowableReplay$InnerSubscription != null) {
            do {
                flowableReplay$InnerSubscriptionArr = this.subscribers.get();
                if (flowableReplay$InnerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = flowableReplay$InnerSubscriptionArr.length;
                flowableReplay$InnerSubscriptionArr2 = new FlowableReplay$InnerSubscription[length + 1];
                System.arraycopy(flowableReplay$InnerSubscriptionArr, 0, flowableReplay$InnerSubscriptionArr2, 0, length);
                flowableReplay$InnerSubscriptionArr2[length] = flowableReplay$InnerSubscription;
            } while (!this.subscribers.compareAndSet(flowableReplay$InnerSubscriptionArr, flowableReplay$InnerSubscriptionArr2));
            return true;
        }
        throw null;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.subscribers.set(TERMINATED);
        SubscriptionHelper.cancel(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.subscribers.get() == TERMINATED;
    }

    public void manageRequests() {
        if (this.management.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        while (!isDisposed()) {
            FlowableReplay$InnerSubscription<T>[] flowableReplay$InnerSubscriptionArr = this.subscribers.get();
            long j = this.maxChildRequested;
            long j2 = j;
            for (FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription : flowableReplay$InnerSubscriptionArr) {
                j2 = Math.max(j2, flowableReplay$InnerSubscription.totalRequested.get());
            }
            long j3 = this.maxUpstreamRequested;
            d dVar = get();
            long j4 = j2 - j;
            if (j4 != 0) {
                this.maxChildRequested = j2;
                if (dVar == null) {
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = Long.MAX_VALUE;
                    }
                    this.maxUpstreamRequested = j5;
                } else if (j3 != 0) {
                    this.maxUpstreamRequested = 0L;
                    dVar.request(j3 + j4);
                } else {
                    dVar.request(j4);
                }
            } else if (j3 != 0 && dVar != null) {
                this.maxUpstreamRequested = 0L;
                dVar.request(j3);
            }
            i = this.management.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.buffer.complete();
        for (FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription : this.subscribers.getAndSet(TERMINATED)) {
            this.buffer.replay(flowableReplay$InnerSubscription);
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (!this.done) {
            this.done = true;
            this.buffer.error(th);
            for (FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(flowableReplay$InnerSubscription);
            }
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        this.buffer.next(t);
        for (FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription : this.subscribers.get()) {
            this.buffer.replay(flowableReplay$InnerSubscription);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            manageRequests();
            for (FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription : this.subscribers.get()) {
                this.buffer.replay(flowableReplay$InnerSubscription);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription<T>[] flowableReplay$InnerSubscriptionArr;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr2;
        do {
            flowableReplay$InnerSubscriptionArr = this.subscribers.get();
            int length = flowableReplay$InnerSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (flowableReplay$InnerSubscriptionArr[i2].equals(flowableReplay$InnerSubscription)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                flowableReplay$InnerSubscriptionArr2 = EMPTY;
            } else {
                FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr3 = new FlowableReplay$InnerSubscription[length - 1];
                System.arraycopy(flowableReplay$InnerSubscriptionArr, 0, flowableReplay$InnerSubscriptionArr3, 0, i);
                System.arraycopy(flowableReplay$InnerSubscriptionArr, i + 1, flowableReplay$InnerSubscriptionArr3, i, (length - i) - 1);
                flowableReplay$InnerSubscriptionArr2 = flowableReplay$InnerSubscriptionArr3;
            }
        } while (!this.subscribers.compareAndSet(flowableReplay$InnerSubscriptionArr, flowableReplay$InnerSubscriptionArr2));
    }
}
