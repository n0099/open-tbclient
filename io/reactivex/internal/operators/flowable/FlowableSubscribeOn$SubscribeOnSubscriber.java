package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.p;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements g<T>, d, Runnable {
    public static final long serialVersionUID = 8094547886072529208L;
    public final c<? super T> actual;
    public final boolean nonScheduledRequests;
    public b<T> source;
    public final p.c worker;
    public final AtomicReference<d> s = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    /* loaded from: classes7.dex */
    public static final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d f69042e;

        /* renamed from: f  reason: collision with root package name */
        public final long f69043f;

        public a(d dVar, long j) {
            this.f69042e = dVar;
            this.f69043f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f69042e.request(this.f69043f);
        }
    }

    public FlowableSubscribeOn$SubscribeOnSubscriber(c<? super T> cVar, p.c cVar2, b<T> bVar, boolean z) {
        this.actual = cVar;
        this.worker = cVar2;
        this.source = bVar;
        this.nonScheduledRequests = !z;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.s);
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onComplete() {
        this.actual.onComplete();
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.actual.onError(th);
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.s, dVar)) {
            long andSet = this.requested.getAndSet(0L);
            if (andSet != 0) {
                requestUpstream(andSet, dVar);
            }
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            d dVar = this.s.get();
            if (dVar != null) {
                requestUpstream(j, dVar);
                return;
            }
            f.b.x.i.b.a(this.requested, j);
            d dVar2 = this.s.get();
            if (dVar2 != null) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar2);
                }
            }
        }
    }

    public void requestUpstream(long j, d dVar) {
        if (!this.nonScheduledRequests && Thread.currentThread() != get()) {
            this.worker.b(new a(dVar, j));
        } else {
            dVar.request(j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());
        b<T> bVar = this.source;
        this.source = null;
        bVar.subscribe(this);
    }
}
