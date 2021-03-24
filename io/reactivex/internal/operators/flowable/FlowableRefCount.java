package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.t.b;
import f.a.x.e.a.a;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class FlowableRefCount<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    public final f.a.v.a<T> f68028f;

    /* renamed from: g  reason: collision with root package name */
    public volatile f.a.t.a f68029g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f68030h;
    public final ReentrantLock i;

    /* loaded from: classes7.dex */
    public final class ConnectionSubscriber extends AtomicReference<d> implements g<T>, d {
        public static final long serialVersionUID = 152064694420235350L;
        public final f.a.t.a currentBase;
        public final AtomicLong requested = new AtomicLong();
        public final b resource;
        public final c<? super T> subscriber;

        public ConnectionSubscriber(c<? super T> cVar, f.a.t.a aVar, b bVar) {
            this.subscriber = cVar;
            this.currentBase = aVar;
            this.resource = bVar;
        }

        @Override // g.d.d
        public void cancel() {
            SubscriptionHelper.cancel(this);
            this.resource.dispose();
        }

        public void cleanup() {
            FlowableRefCount.this.i.lock();
            try {
                if (FlowableRefCount.this.f68029g == this.currentBase) {
                    f.a.v.a<T> aVar = FlowableRefCount.this.f68028f;
                    FlowableRefCount.this.f68029g.dispose();
                    FlowableRefCount.this.f68029g = new f.a.t.a();
                    FlowableRefCount.this.f68030h.set(0);
                }
            } finally {
                FlowableRefCount.this.i.unlock();
            }
        }

        @Override // g.d.c
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // g.d.c
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // g.d.c
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // f.a.g, g.d.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
        }

        @Override // g.d.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }
    }
}
