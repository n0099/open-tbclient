package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.t.b;
import f.b.x.e.a.a;
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
    public final f.b.v.a<T> f69039f;

    /* renamed from: g  reason: collision with root package name */
    public volatile f.b.t.a f69040g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f69041h;
    public final ReentrantLock i;

    /* loaded from: classes7.dex */
    public final class ConnectionSubscriber extends AtomicReference<d> implements g<T>, d {
        public static final long serialVersionUID = 152064694420235350L;
        public final f.b.t.a currentBase;
        public final AtomicLong requested = new AtomicLong();
        public final b resource;
        public final c<? super T> subscriber;

        public ConnectionSubscriber(c<? super T> cVar, f.b.t.a aVar, b bVar) {
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
                if (FlowableRefCount.this.f69040g == this.currentBase) {
                    f.b.v.a<T> aVar = FlowableRefCount.this.f69039f;
                    FlowableRefCount.this.f69040g.dispose();
                    FlowableRefCount.this.f69040g = new f.b.t.a();
                    FlowableRefCount.this.f69041h.set(0);
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

        @Override // f.b.g, g.d.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
        }

        @Override // g.d.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }
    }
}
