package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.t.b;
import f.a.x.c.f;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowablePublish$PublishSubscriber<T> extends AtomicInteger implements g<T>, b {
    public static final FlowablePublish$InnerSubscriber[] EMPTY = new FlowablePublish$InnerSubscriber[0];
    public static final FlowablePublish$InnerSubscriber[] TERMINATED = new FlowablePublish$InnerSubscriber[0];
    public static final long serialVersionUID = -202316842419149694L;
    public final int bufferSize;
    public final AtomicReference<FlowablePublish$PublishSubscriber<T>> current;
    public volatile f<T> queue;
    public int sourceMode;
    public volatile Object terminalEvent;
    public final AtomicReference<d> s = new AtomicReference<>();
    public final AtomicReference<FlowablePublish$InnerSubscriber[]> subscribers = new AtomicReference<>(EMPTY);
    public final AtomicBoolean shouldConnect = new AtomicBoolean();

    public FlowablePublish$PublishSubscriber(AtomicReference<FlowablePublish$PublishSubscriber<T>> atomicReference, int i) {
        this.current = atomicReference;
        this.bufferSize = i;
    }

    public boolean add(FlowablePublish$InnerSubscriber<T> flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2;
        do {
            flowablePublish$InnerSubscriberArr = this.subscribers.get();
            if (flowablePublish$InnerSubscriberArr == TERMINATED) {
                return false;
            }
            int length = flowablePublish$InnerSubscriberArr.length;
            flowablePublish$InnerSubscriberArr2 = new FlowablePublish$InnerSubscriber[length + 1];
            System.arraycopy(flowablePublish$InnerSubscriberArr, 0, flowablePublish$InnerSubscriberArr2, 0, length);
            flowablePublish$InnerSubscriberArr2[length] = flowablePublish$InnerSubscriber;
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriberArr, flowablePublish$InnerSubscriberArr2));
        return true;
    }

    public boolean checkTerminated(Object obj, boolean z) {
        int i = 0;
        if (obj != null) {
            if (!NotificationLite.isComplete(obj)) {
                Throwable error = NotificationLite.getError(obj);
                this.current.compareAndSet(this, null);
                FlowablePublish$InnerSubscriber[] andSet = this.subscribers.getAndSet(TERMINATED);
                if (andSet.length != 0) {
                    int length = andSet.length;
                    while (i < length) {
                        andSet[i].child.onError(error);
                        i++;
                    }
                } else {
                    a.f(error);
                }
                return true;
            } else if (z) {
                this.current.compareAndSet(this, null);
                FlowablePublish$InnerSubscriber[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                int length2 = andSet2.length;
                while (i < length2) {
                    andSet2[i].child.onComplete();
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0114, code lost:
        if (r16 == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatch() {
        int i;
        long j;
        long j2;
        T t;
        T t2;
        if (getAndIncrement() != 0) {
            return;
        }
        int i2 = 1;
        int i3 = 1;
        while (true) {
            Object obj = this.terminalEvent;
            f<T> fVar = this.queue;
            boolean z = fVar == null || fVar.isEmpty();
            if (checkTerminated(obj, z)) {
                return;
            }
            if (z) {
                i = i3;
            } else {
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr = this.subscribers.get();
                int length = flowablePublish$InnerSubscriberArr.length;
                long j3 = Long.MAX_VALUE;
                int length2 = flowablePublish$InnerSubscriberArr.length;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    j = 0;
                    if (i4 >= length2) {
                        break;
                    }
                    boolean z2 = z;
                    long j4 = flowablePublish$InnerSubscriberArr[i4].get();
                    if (j4 >= 0) {
                        j3 = Math.min(j3, j4);
                    } else if (j4 == Long.MIN_VALUE) {
                        i5++;
                    }
                    i4++;
                    z = z2;
                }
                boolean z3 = z;
                if (length == i5) {
                    Object obj2 = this.terminalEvent;
                    try {
                        t2 = fVar.poll();
                    } catch (Throwable th) {
                        f.a.u.a.a(th);
                        this.s.get().cancel();
                        obj2 = NotificationLite.error(th);
                        this.terminalEvent = obj2;
                        t2 = null;
                    }
                    if (checkTerminated(obj2, t2 == null)) {
                        return;
                    }
                    if (this.sourceMode != i2) {
                        this.s.get().request(1L);
                    }
                    i = i3;
                } else {
                    i = i3;
                    int i6 = 0;
                    while (true) {
                        j2 = i6;
                        if (j2 >= j3) {
                            break;
                        }
                        Object obj3 = this.terminalEvent;
                        try {
                            t = fVar.poll();
                        } catch (Throwable th2) {
                            f.a.u.a.a(th2);
                            this.s.get().cancel();
                            obj3 = NotificationLite.error(th2);
                            this.terminalEvent = obj3;
                            t = null;
                        }
                        boolean z4 = t == null;
                        if (checkTerminated(obj3, z4)) {
                            return;
                        }
                        if (z4) {
                            z3 = z4;
                            break;
                        }
                        Object value = NotificationLite.getValue(t);
                        int length3 = flowablePublish$InnerSubscriberArr.length;
                        int i7 = 0;
                        while (i7 < length3) {
                            FlowablePublish$InnerSubscriber flowablePublish$InnerSubscriber = flowablePublish$InnerSubscriberArr[i7];
                            if (flowablePublish$InnerSubscriber.get() > j) {
                                flowablePublish$InnerSubscriber.child.onNext(value);
                                flowablePublish$InnerSubscriber.produced(1L);
                            }
                            i7++;
                            j = 0;
                        }
                        i6++;
                        z3 = z4;
                        j = 0;
                    }
                    if (i6 > 0 && this.sourceMode != 1) {
                        this.s.get().request(j2);
                    }
                    if (j3 != 0) {
                    }
                }
                i3 = i;
                i2 = 1;
            }
            i3 = addAndGet(-i);
            if (i3 == 0) {
                return;
            }
            i2 = 1;
        }
    }

    @Override // f.a.t.b
    public void dispose() {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr = this.subscribers.get();
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2 = TERMINATED;
        if (flowablePublish$InnerSubscriberArr == flowablePublish$InnerSubscriberArr2 || this.subscribers.getAndSet(flowablePublish$InnerSubscriberArr2) == TERMINATED) {
            return;
        }
        this.current.compareAndSet(this, null);
        SubscriptionHelper.cancel(this.s);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.subscribers.get() == TERMINATED;
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.terminalEvent == null) {
            this.terminalEvent = NotificationLite.complete();
            dispatch();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.terminalEvent == null) {
            this.terminalEvent = NotificationLite.error(th);
            dispatch();
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        } else {
            dispatch();
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.s, dVar)) {
            if (dVar instanceof f.a.x.c.d) {
                f.a.x.c.d dVar2 = (f.a.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.terminalEvent = NotificationLite.complete();
                    dispatch();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    dVar.request(this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            dVar.request(this.bufferSize);
        }
    }

    public void remove(FlowablePublish$InnerSubscriber<T> flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2;
        do {
            flowablePublish$InnerSubscriberArr = this.subscribers.get();
            int length = flowablePublish$InnerSubscriberArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (flowablePublish$InnerSubscriberArr[i2].equals(flowablePublish$InnerSubscriber)) {
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
                flowablePublish$InnerSubscriberArr2 = EMPTY;
            } else {
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr3 = new FlowablePublish$InnerSubscriber[length - 1];
                System.arraycopy(flowablePublish$InnerSubscriberArr, 0, flowablePublish$InnerSubscriberArr3, 0, i);
                System.arraycopy(flowablePublish$InnerSubscriberArr, i + 1, flowablePublish$InnerSubscriberArr3, i, (length - i) - 1);
                flowablePublish$InnerSubscriberArr2 = flowablePublish$InnerSubscriberArr3;
            }
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriberArr, flowablePublish$InnerSubscriberArr2));
    }
}
