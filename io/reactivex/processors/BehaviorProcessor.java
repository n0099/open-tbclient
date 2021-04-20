package io.reactivex.processors;

import f.b.b0.a;
import f.b.x.i.a;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
/* loaded from: classes7.dex */
public final class BehaviorProcessor<T> extends a<T> {

    /* renamed from: f  reason: collision with root package name */
    public final Lock f69106f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Object> f69107g;

    /* renamed from: h  reason: collision with root package name */
    public long f69108h;

    /* loaded from: classes7.dex */
    public static final class BehaviorSubscription<T> extends AtomicLong implements d, a.InterfaceC1893a<Object> {
        public static final long serialVersionUID = 3293175281126227086L;
        public final c<? super T> actual;
        public volatile boolean cancelled;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public f.b.x.i.a<Object> queue;
        public final BehaviorProcessor<T> state;

        public BehaviorSubscription(c<? super T> cVar, BehaviorProcessor<T> behaviorProcessor) {
            this.actual = cVar;
            this.state = behaviorProcessor;
        }

        @Override // g.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.d(this);
        }

        public void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorProcessor<T> behaviorProcessor = this.state;
                Lock lock = behaviorProcessor.f69106f;
                lock.lock();
                this.index = behaviorProcessor.f69108h;
                Object obj = behaviorProcessor.f69107g.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        public void emitLoop() {
            f.b.x.i.a<Object> aVar;
            while (!this.cancelled) {
                synchronized (this) {
                    aVar = this.queue;
                    if (aVar == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                aVar.b(this);
            }
        }

        public void emitNext(Object obj, long j) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        f.b.x.i.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new f.b.x.i.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.a(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        public boolean isFull() {
            return get() == 0;
        }

        @Override // g.d.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this, j);
            }
        }

        @Override // f.b.x.i.a.InterfaceC1893a, f.b.w.i
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
                        return false;
                    }
                    return false;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }
    }

    public abstract void d(BehaviorSubscription<T> behaviorSubscription);
}
