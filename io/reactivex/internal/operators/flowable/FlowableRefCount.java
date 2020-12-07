package io.reactivex.internal.operators.flowable;

import io.reactivex.b.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.a.d;
/* loaded from: classes9.dex */
public final class FlowableRefCount<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final ReentrantLock lock;
    final io.reactivex.a.a<T> pFH;
    volatile io.reactivex.disposables.a pFI;
    final AtomicInteger pFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class ConnectionSubscriber extends AtomicReference<d> implements j<T>, d {
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
        public void onSubscribe(d dVar) {
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
                if (FlowableRefCount.this.pFI == this.currentBase) {
                    if (FlowableRefCount.this.pFH instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) FlowableRefCount.this.pFH).dispose();
                    }
                    FlowableRefCount.this.pFI.dispose();
                    FlowableRefCount.this.pFI = new io.reactivex.disposables.a();
                    FlowableRefCount.this.pFJ.set(0);
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
        if (this.pFJ.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.pFH.a(a(cVar, atomicBoolean));
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
            a(cVar, this.pFI);
        } finally {
            this.lock.unlock();
        }
    }

    private g<io.reactivex.disposables.b> a(org.a.c<? super T> cVar, AtomicBoolean atomicBoolean) {
        return new a(cVar, atomicBoolean);
    }

    void a(org.a.c<? super T> cVar, io.reactivex.disposables.a aVar) {
        ConnectionSubscriber connectionSubscriber = new ConnectionSubscriber(cVar, aVar, a(aVar));
        cVar.onSubscribe(connectionSubscriber);
        this.pFH.a((j) connectionSubscriber);
    }

    private io.reactivex.disposables.b a(io.reactivex.disposables.a aVar) {
        return io.reactivex.disposables.c.I(new b(aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class a implements g<io.reactivex.disposables.b> {
        private final AtomicBoolean pFK;
        private final org.a.c<? super T> subscriber;

        a(org.a.c<? super T> cVar, AtomicBoolean atomicBoolean) {
            this.subscriber = cVar;
            this.pFK = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.g
        /* renamed from: f */
        public void accept(io.reactivex.disposables.b bVar) {
            try {
                FlowableRefCount.this.pFI.a(bVar);
                FlowableRefCount.this.a(this.subscriber, FlowableRefCount.this.pFI);
            } finally {
                FlowableRefCount.this.lock.unlock();
                this.pFK.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class b implements Runnable {
        private final io.reactivex.disposables.a pFL;

        b(io.reactivex.disposables.a aVar) {
            this.pFL = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            FlowableRefCount.this.lock.lock();
            try {
                if (FlowableRefCount.this.pFI == this.pFL && FlowableRefCount.this.pFJ.decrementAndGet() == 0) {
                    if (FlowableRefCount.this.pFH instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) FlowableRefCount.this.pFH).dispose();
                    }
                    FlowableRefCount.this.pFI.dispose();
                    FlowableRefCount.this.pFI = new io.reactivex.disposables.a();
                }
            } finally {
                FlowableRefCount.this.lock.unlock();
            }
        }
    }
}
