package io.reactivex.internal.operators.observable;

import io.reactivex.c.g;
import io.reactivex.disposables.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes17.dex */
public final class ObservableRefCount<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final ReentrantLock lock;
    volatile io.reactivex.disposables.a pNr;
    final AtomicInteger pNs;
    final io.reactivex.d.a<? extends T> pOu;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        boolean z;
        this.lock.lock();
        if (this.pNs.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.pOu.c(a(uVar, atomicBoolean));
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
            a(uVar, this.pNr);
        } finally {
            this.lock.unlock();
        }
    }

    private g<io.reactivex.disposables.b> a(u<? super T> uVar, AtomicBoolean atomicBoolean) {
        return new a(uVar, atomicBoolean);
    }

    void a(u<? super T> uVar, io.reactivex.disposables.a aVar) {
        ConnectionObserver connectionObserver = new ConnectionObserver(uVar, aVar, a(aVar));
        uVar.onSubscribe(connectionObserver);
        this.pOu.subscribe(connectionObserver);
    }

    private io.reactivex.disposables.b a(io.reactivex.disposables.a aVar) {
        return c.J(new b(aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public final class ConnectionObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 3813126992133394324L;
        final io.reactivex.disposables.a currentBase;
        final io.reactivex.disposables.b resource;
        final u<? super T> subscriber;

        ConnectionObserver(u<? super T> uVar, io.reactivex.disposables.a aVar, io.reactivex.disposables.b bVar) {
            this.subscriber = uVar;
            this.currentBase = aVar;
            this.resource = bVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.resource.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        void cleanup() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.pNr == this.currentBase) {
                    if (ObservableRefCount.this.pOu instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) ObservableRefCount.this.pOu).dispose();
                    }
                    ObservableRefCount.this.pNr.dispose();
                    ObservableRefCount.this.pNr = new io.reactivex.disposables.a();
                    ObservableRefCount.this.pNs.set(0);
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public final class a implements g<io.reactivex.disposables.b> {
        private final u<? super T> observer;
        private final AtomicBoolean pNt;

        a(u<? super T> uVar, AtomicBoolean atomicBoolean) {
            this.observer = uVar;
            this.pNt = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        /* renamed from: f */
        public void accept(io.reactivex.disposables.b bVar) {
            try {
                ObservableRefCount.this.pNr.a(bVar);
                ObservableRefCount.this.a(this.observer, ObservableRefCount.this.pNr);
            } finally {
                ObservableRefCount.this.lock.unlock();
                this.pNt.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public final class b implements Runnable {
        private final io.reactivex.disposables.a pNu;

        b(io.reactivex.disposables.a aVar) {
            this.pNu = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.pNr == this.pNu && ObservableRefCount.this.pNs.decrementAndGet() == 0) {
                    if (ObservableRefCount.this.pOu instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) ObservableRefCount.this.pOu).dispose();
                    }
                    ObservableRefCount.this.pNr.dispose();
                    ObservableRefCount.this.pNr = new io.reactivex.disposables.a();
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }
}
