package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableRefCount<T> extends io.reactivex.g<T> {
    RefConnection connection;
    final int n;
    final io.reactivex.b.a<T> nxl;
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        RefConnection refConnection;
        boolean z = true;
        synchronized (this) {
            refConnection = this.connection;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.connection = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            refConnection.subscriberCount = j + 1;
            if (refConnection.connected || j + 1 != this.n) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.nxl.a((j) new RefCountSubscriber(cVar, this, refConnection));
        if (z) {
            this.nxl.c(refConnection);
        }
    }

    void a(RefConnection refConnection) {
        synchronized (this) {
            if (this.connection != null) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.timeout == 0) {
                        c(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.replace(this.scheduler.b(refConnection, this.timeout, this.unit));
                }
            }
        }
    }

    void b(RefConnection refConnection) {
        synchronized (this) {
            if (this.connection != null) {
                this.connection = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
                if (this.nxl instanceof io.reactivex.disposables.b) {
                    ((io.reactivex.disposables.b) this.nxl).dispose();
                }
            }
        }
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                this.connection = null;
                DisposableHelper.dispose(refConnection);
                if (this.nxl instanceof io.reactivex.disposables.b) {
                    ((io.reactivex.disposables.b) this.nxl).dispose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c.g<io.reactivex.disposables.b>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        final FlowableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.b timer;

        RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.c(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(io.reactivex.disposables.b bVar) throws Exception {
            DisposableHelper.replace(this, bVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class RefCountSubscriber<T> extends AtomicBoolean implements j<T>, org.a.d {
        private static final long serialVersionUID = -7419642935409022375L;
        final org.a.c<? super T> actual;
        final RefConnection connection;
        final FlowableRefCount<T> parent;
        org.a.d upstream;

        RefCountSubscriber(org.a.c<? super T> cVar, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.actual = cVar;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.actual.onComplete();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.a(this.connection);
            }
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.actual.onSubscribe(this);
            }
        }
    }
}
