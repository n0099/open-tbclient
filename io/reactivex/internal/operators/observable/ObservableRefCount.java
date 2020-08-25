package io.reactivex.internal.operators.observable;

import io.reactivex.c.g;
import io.reactivex.disposables.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class ObservableRefCount<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final ReentrantLock lock;
    volatile io.reactivex.disposables.a onk;
    final AtomicInteger onl;
    final io.reactivex.d.a<? extends T> oon;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        boolean z;
        this.lock.lock();
        if (this.onl.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.oon.c(a(uVar, atomicBoolean));
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
            a(uVar, this.onk);
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
        this.oon.subscribe(connectionObserver);
    }

    private io.reactivex.disposables.b a(io.reactivex.disposables.a aVar) {
        return c.H(new b(aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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
                if (ObservableRefCount.this.onk == this.currentBase) {
                    if (ObservableRefCount.this.oon instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) ObservableRefCount.this.oon).dispose();
                    }
                    ObservableRefCount.this.onk.dispose();
                    ObservableRefCount.this.onk = new io.reactivex.disposables.a();
                    ObservableRefCount.this.onl.set(0);
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class a implements g<io.reactivex.disposables.b> {
        private final u<? super T> observer;
        private final AtomicBoolean onm;

        a(u<? super T> uVar, AtomicBoolean atomicBoolean) {
            this.observer = uVar;
            this.onm = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        /* renamed from: f */
        public void accept(io.reactivex.disposables.b bVar) {
            try {
                ObservableRefCount.this.onk.a(bVar);
                ObservableRefCount.this.a(this.observer, ObservableRefCount.this.onk);
            } finally {
                ObservableRefCount.this.lock.unlock();
                this.onm.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class b implements Runnable {
        private final io.reactivex.disposables.a onn;

        b(io.reactivex.disposables.a aVar) {
            this.onn = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.onk == this.onn && ObservableRefCount.this.onl.decrementAndGet() == 0) {
                    if (ObservableRefCount.this.oon instanceof io.reactivex.disposables.b) {
                        ((io.reactivex.disposables.b) ObservableRefCount.this.oon).dispose();
                    }
                    ObservableRefCount.this.onk.dispose();
                    ObservableRefCount.this.onk = new io.reactivex.disposables.a();
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }
}
