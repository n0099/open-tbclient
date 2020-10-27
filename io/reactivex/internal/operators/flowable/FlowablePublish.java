package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class FlowablePublish<T> extends io.reactivex.b.a<T> {
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final org.a.b<T> pDR;
    final io.reactivex.g<T> pDq;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.pDR.subscribe(cVar);
    }

    @Override // io.reactivex.b.a
    public void c(io.reactivex.c.g<? super io.reactivex.disposables.b> gVar) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.current, this.bufferSize);
            if (this.current.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = !publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(publishSubscriber);
            if (z) {
                this.pDq.a((j) publishSubscriber);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            throw ExceptionHelper.L(th);
        }
    }

    /* loaded from: classes17.dex */
    static final class PublishSubscriber<T> extends AtomicInteger implements io.reactivex.disposables.b, j<T> {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile io.reactivex.internal.a.g<T> queue;
        int sourceMode;
        volatile Object terminalEvent;
        final AtomicReference<org.a.d> s = new AtomicReference<>();
        final AtomicReference<InnerSubscriber[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.subscribers.get() != TERMINATED && this.subscribers.getAndSet(TERMINATED) != TERMINATED) {
                this.current.compareAndSet(this, null);
                SubscriptionHelper.cancel(this.s);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this.s, dVar)) {
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
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

        @Override // org.a.c
        public void onNext(T t) {
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            } else {
                dispatch();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = EMPTY;
                        } else {
                            innerSubscriberArr2 = new InnerSubscriber[length - 1];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                            System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (NotificationLite.isComplete(obj)) {
                    if (z) {
                        this.current.compareAndSet(this, null);
                        InnerSubscriber[] andSet = this.subscribers.getAndSet(TERMINATED);
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onComplete();
                            i++;
                        }
                        return true;
                    }
                } else {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    if (andSet2.length != 0) {
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onError(error);
                            i++;
                        }
                    } else {
                        io.reactivex.e.a.onError(error);
                    }
                    return true;
                }
            }
            return false;
        }

        void dispatch() {
            T t;
            Object obj;
            T t2;
            if (getAndIncrement() == 0) {
                int i = 1;
                while (true) {
                    Object obj2 = this.terminalEvent;
                    io.reactivex.internal.a.g<T> gVar = this.queue;
                    boolean z = gVar == null || gVar.isEmpty();
                    if (!checkTerminated(obj2, z)) {
                        if (!z) {
                            InnerSubscriber[] innerSubscriberArr = this.subscribers.get();
                            int length = innerSubscriberArr.length;
                            int i2 = 0;
                            long j = Long.MAX_VALUE;
                            for (InnerSubscriber innerSubscriber : innerSubscriberArr) {
                                long j2 = innerSubscriber.get();
                                if (j2 >= 0) {
                                    j = Math.min(j, j2);
                                } else if (j2 == Long.MIN_VALUE) {
                                    i2++;
                                }
                            }
                            if (length == i2) {
                                Object obj3 = this.terminalEvent;
                                try {
                                    t = gVar.poll();
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.J(th);
                                    this.s.get().cancel();
                                    obj3 = NotificationLite.error(th);
                                    this.terminalEvent = obj3;
                                    t = null;
                                }
                                if (!checkTerminated(obj3, t == null)) {
                                    if (this.sourceMode != 1) {
                                        this.s.get().request(1L);
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                int i3 = 0;
                                while (i3 < j) {
                                    try {
                                        obj = this.terminalEvent;
                                        t2 = gVar.poll();
                                    } catch (Throwable th2) {
                                        io.reactivex.exceptions.a.J(th2);
                                        this.s.get().cancel();
                                        Object error = NotificationLite.error(th2);
                                        this.terminalEvent = error;
                                        obj = error;
                                        t2 = null;
                                    }
                                    z = t2 == null;
                                    if (!checkTerminated(obj, z)) {
                                        if (z) {
                                            break;
                                        }
                                        Object value = NotificationLite.getValue(t2);
                                        for (InnerSubscriber innerSubscriber2 : innerSubscriberArr) {
                                            if (innerSubscriber2.get() > 0) {
                                                innerSubscriber2.child.onNext(value);
                                                innerSubscriber2.produced(1L);
                                            }
                                        }
                                        i3++;
                                    } else {
                                        return;
                                    }
                                }
                                if (i3 > 0 && this.sourceMode != 1) {
                                    this.s.get().request(i3);
                                }
                                if (j != 0 && !z) {
                                }
                            }
                        }
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class InnerSubscriber<T> extends AtomicLong implements org.a.d {
        private static final long serialVersionUID = -4453897557930727610L;
        final org.a.c<? super T> child;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(org.a.c<? super T> cVar) {
            this.child = cVar;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this, j);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }

        public long produced(long j) {
            return io.reactivex.internal.util.b.d(this, j);
        }

        @Override // org.a.d
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (publishSubscriber = this.parent) != null) {
                publishSubscriber.remove(this);
                publishSubscriber.dispatch();
            }
        }
    }
}
