package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import org.a.c;
import org.a.d;
/* loaded from: classes17.dex */
public final class BehaviorProcessor<T> extends a<T> {
    static final Object[] pRa = new Object[0];
    static final BehaviorSubscription[] pRb = new BehaviorSubscription[0];
    static final BehaviorSubscription[] pRc = new BehaviorSubscription[0];
    long index;
    final Lock pRd;
    final Lock pRe;
    final AtomicReference<Throwable> pRf;
    final AtomicReference<BehaviorSubscription<T>[]> subscribers;
    final AtomicReference<Object> value;

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        BehaviorSubscription<T> behaviorSubscription = new BehaviorSubscription<>(cVar, this);
        cVar.onSubscribe(behaviorSubscription);
        if (a(behaviorSubscription)) {
            if (behaviorSubscription.cancelled) {
                b(behaviorSubscription);
                return;
            } else {
                behaviorSubscription.emitFirst();
                return;
            }
        }
        Throwable th = this.pRf.get();
        if (th == ExceptionHelper.TERMINATED) {
            cVar.onComplete();
        } else {
            cVar.onError(th);
        }
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (this.pRf.get() != null) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        io.reactivex.internal.functions.a.l(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.pRf.get() == null) {
            Object next = NotificationLite.next(t);
            bQ(next);
            for (BehaviorSubscription<T> behaviorSubscription : this.subscribers.get()) {
                behaviorSubscription.emitNext(next, this.index);
            }
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.l(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.pRf.compareAndSet(null, th)) {
            io.reactivex.e.a.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (BehaviorSubscription<T> behaviorSubscription : bP(error)) {
            behaviorSubscription.emitNext(error, this.index);
        }
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.pRf.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription<T> behaviorSubscription : bP(complete)) {
                behaviorSubscription.emitNext(complete, this.index);
            }
        }
    }

    boolean a(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.subscribers.get();
            if (behaviorSubscriptionArr == pRc) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[length + 1];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    void b(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.subscribers.get();
            if (behaviorSubscriptionArr != pRc && behaviorSubscriptionArr != pRb) {
                int length = behaviorSubscriptionArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (behaviorSubscriptionArr[i2] == behaviorSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        behaviorSubscriptionArr2 = pRb;
                    } else {
                        behaviorSubscriptionArr2 = new BehaviorSubscription[length - 1];
                        System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, i);
                        System.arraycopy(behaviorSubscriptionArr, i + 1, behaviorSubscriptionArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    BehaviorSubscription<T>[] bP(Object obj) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr = this.subscribers.get();
        if (behaviorSubscriptionArr != pRc && (behaviorSubscriptionArr = this.subscribers.getAndSet(pRc)) != pRc) {
            bQ(obj);
        }
        return behaviorSubscriptionArr;
    }

    void bQ(Object obj) {
        Lock lock = this.pRe;
        lock.lock();
        this.index++;
        this.value.lazySet(obj);
        lock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class BehaviorSubscription<T> extends AtomicLong implements a.InterfaceC1075a<Object>, d {
        private static final long serialVersionUID = 3293175281126227086L;
        final c<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.a<Object> queue;
        final BehaviorProcessor<T> state;

        BehaviorSubscription(c<? super T> cVar, BehaviorProcessor<T> behaviorProcessor) {
            this.actual = cVar;
            this.state = behaviorProcessor;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.b(this);
            }
        }

        void emitFirst() {
            if (!this.cancelled) {
                synchronized (this) {
                    if (!this.cancelled) {
                        if (!this.next) {
                            BehaviorProcessor<T> behaviorProcessor = this.state;
                            Lock lock = behaviorProcessor.pRd;
                            lock.lock();
                            this.index = behaviorProcessor.index;
                            Object obj = behaviorProcessor.value.get();
                            lock.unlock();
                            this.emitting = obj != null;
                            this.next = true;
                            if (obj != null && !test(obj)) {
                                emitLoop();
                            }
                        }
                    }
                }
            }
        }

        void emitNext(Object obj, long j) {
            if (!this.cancelled) {
                if (!this.fastPath) {
                    synchronized (this) {
                        if (!this.cancelled) {
                            if (this.index != j) {
                                if (this.emitting) {
                                    io.reactivex.internal.util.a<Object> aVar = this.queue;
                                    if (aVar == null) {
                                        aVar = new io.reactivex.internal.util.a<>(4);
                                        this.queue = aVar;
                                    }
                                    aVar.add(obj);
                                    return;
                                }
                                this.next = true;
                                this.fastPath = true;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                test(obj);
            }
        }

        @Override // io.reactivex.internal.util.a.InterfaceC1075a, io.reactivex.c.j
        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.actual.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.actual.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j != 0) {
                    this.actual.onNext((Object) NotificationLite.getValue(obj));
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                    return false;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }

        void emitLoop() {
            io.reactivex.internal.util.a<Object> aVar;
            while (!this.cancelled) {
                synchronized (this) {
                    aVar = this.queue;
                    if (aVar == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                aVar.a(this);
            }
        }

        public boolean isFull() {
            return get() == 0;
        }
    }
}
