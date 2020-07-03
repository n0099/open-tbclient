package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class FlowableRefCount<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final ReentrantLock lock;
    final io.reactivex.b.a<T> nKA;
    volatile io.reactivex.disposables.a nKB;
    final AtomicInteger nKC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class ConnectionSubscriber extends AtomicReference<org.a.d> implements j<T>, org.a.d {
        private static final long serialVersionUID = 152064694420235350L;
        final io.reactivex.disposables.a currentBase;
        final AtomicLong requested = new AtomicLong();
        final io.reactivex.disposables.b resource;
        final org.a.c<? super T> subscriber;

        ConnectionSubscriber(org.a.c<? super T> cVar, io.reactivex.disposables.a aVar, io.reactivex.disposables.b bVar) {
            this.subscriber = cVar;
            this.currentBase = aVar;
            this.resource = bVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // org.a.c
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this);
            this.resource.dispose();
        }

        void cleanup() {
            FlowableRefCount.this.lock.lock();
            try {
                if (FlowableRefCount.this.nKB == this.currentBase) {
                    if (FlowableRefCount.this.nKA instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) FlowableRefCount.this.nKA).dispose();
                    }
                    FlowableRefCount.this.nKB.dispose();
                    FlowableRefCount.this.nKB = new io.reactivex.disposables.a();
                    FlowableRefCount.this.nKC.set(0);
                }
            } finally {
                FlowableRefCount.this.lock.unlock();
            }
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        boolean z;
        this.lock.lock();
        if (this.nKC.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.nKA.c(a(cVar, atomicBoolean));
                if (z) {
                    return;
                }
                return;
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            a(cVar, this.nKB);
        } finally {
            this.lock.unlock();
        }
    }

    private io.reactivex.c.g<io.reactivex.disposables.b> a(org.a.c<? super T> cVar, AtomicBoolean atomicBoolean) {
        return new a(cVar, atomicBoolean);
    }

    void a(org.a.c<? super T> cVar, io.reactivex.disposables.a aVar) {
        ConnectionSubscriber connectionSubscriber = new ConnectionSubscriber(cVar, aVar, a(aVar));
        cVar.onSubscribe(connectionSubscriber);
        this.nKA.a((j) connectionSubscriber);
    }

    private io.reactivex.disposables.b a(io.reactivex.disposables.a aVar) {
        return io.reactivex.disposables.c.L(new b(aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class a implements io.reactivex.c.g<io.reactivex.disposables.b> {
        private final AtomicBoolean nKD;
        private final org.a.c<? super T> subscriber;

        a(org.a.c<? super T> cVar, AtomicBoolean atomicBoolean) {
            this.subscriber = cVar;
            this.nKD = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        /* renamed from: f */
        public void accept(io.reactivex.disposables.b bVar) {
            try {
                FlowableRefCount.this.nKB.a(bVar);
                FlowableRefCount.this.a(this.subscriber, FlowableRefCount.this.nKB);
            } finally {
                FlowableRefCount.this.lock.unlock();
                this.nKD.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class b implements Runnable {
        private final io.reactivex.disposables.a nKE;

        b(io.reactivex.disposables.a aVar) {
            this.nKE = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            FlowableRefCount.this.lock.lock();
            try {
                if (FlowableRefCount.this.nKB == this.nKE && FlowableRefCount.this.nKC.decrementAndGet() == 0) {
                    if (FlowableRefCount.this.nKA instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) FlowableRefCount.this.nKA).dispose();
                    }
                    FlowableRefCount.this.nKB.dispose();
                    FlowableRefCount.this.nKB = new io.reactivex.disposables.a();
                }
            } finally {
                FlowableRefCount.this.lock.unlock();
            }
        }
    }
}
