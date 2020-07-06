package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSubscribeOn<T> extends a<T, T> {
    final boolean nonScheduledRequests;
    final v scheduler;

    public FlowableSubscribeOn(io.reactivex.g<T> gVar, v vVar, boolean z) {
        super(gVar);
        this.scheduler = vVar;
        this.nonScheduledRequests = z;
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        v.c dPv = this.scheduler.dPv();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(cVar, dPv, this.nJW, this.nonScheduledRequests);
        cVar.onSubscribe(subscribeOnSubscriber);
        dPv.K(subscribeOnSubscriber);
    }

    /* loaded from: classes7.dex */
    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = 8094547886072529208L;
        final org.a.c<? super T> actual;
        final boolean nonScheduledRequests;
        org.a.b<T> source;
        final v.c worker;
        final AtomicReference<org.a.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        SubscribeOnSubscriber(org.a.c<? super T> cVar, v.c cVar2, org.a.b<T> bVar, boolean z) {
            this.actual = cVar;
            this.worker = cVar2;
            this.source = bVar;
            this.nonScheduledRequests = !z;
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            org.a.b<T> bVar = this.source;
            this.source = null;
            bVar.subscribe(this);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this.s, dVar)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar);
                }
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                org.a.d dVar = this.s.get();
                if (dVar != null) {
                    requestUpstream(j, dVar);
                    return;
                }
                io.reactivex.internal.util.b.a(this.requested, j);
                org.a.d dVar2 = this.s.get();
                if (dVar2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, dVar2);
                    }
                }
            }
        }

        void requestUpstream(long j, org.a.d dVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dVar.request(j);
            } else {
                this.worker.K(new a(dVar, j));
            }
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.s);
            this.worker.dispose();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class a implements Runnable {
            private final long n;
            private final org.a.d s;

            a(org.a.d dVar, long j) {
                this.s = dVar;
                this.n = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.s.request(this.n);
            }
        }
    }
}
