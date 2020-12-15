package io.reactivex.internal.operators.observable;

import io.reactivex.b.g;
import io.reactivex.disposables.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public final class ObservableRefCount<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final ReentrantLock lock;
    volatile io.reactivex.disposables.a pFK;
    final AtomicInteger pFL;
    final io.reactivex.c.a<? extends T> pGN;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        boolean z;
        this.lock.lock();
        if (this.pFL.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.pGN.a(a(uVar, atomicBoolean));
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
            a(uVar, this.pFK);
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
        this.pGN.subscribe(connectionObserver);
    }

    private io.reactivex.disposables.b a(io.reactivex.disposables.a aVar) {
        return c.I(new b(aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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
                if (ObservableRefCount.this.pFK == this.currentBase) {
                    if (ObservableRefCount.this.pGN instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) ObservableRefCount.this.pGN).dispose();
                    }
                    ObservableRefCount.this.pFK.dispose();
                    ObservableRefCount.this.pFK = new io.reactivex.disposables.a();
                    ObservableRefCount.this.pFL.set(0);
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class a implements g<io.reactivex.disposables.b> {
        private final u<? super T> observer;
        private final AtomicBoolean pFM;

        a(u<? super T> uVar, AtomicBoolean atomicBoolean) {
            this.observer = uVar;
            this.pFM = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.g
        /* renamed from: f */
        public void accept(io.reactivex.disposables.b bVar) {
            try {
                ObservableRefCount.this.pFK.a(bVar);
                ObservableRefCount.this.a(this.observer, ObservableRefCount.this.pFK);
            } finally {
                ObservableRefCount.this.lock.unlock();
                this.pFM.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class b implements Runnable {
        private final io.reactivex.disposables.a pFN;

        b(io.reactivex.disposables.a aVar) {
            this.pFN = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.pFK == this.pFN && ObservableRefCount.this.pFL.decrementAndGet() == 0) {
                    if (ObservableRefCount.this.pGN instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) ObservableRefCount.this.pGN).dispose();
                    }
                    ObservableRefCount.this.pFK.dispose();
                    ObservableRefCount.this.pFK = new io.reactivex.disposables.a();
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }
}
