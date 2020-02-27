package io.reactivex.internal.operators.observable;

import io.reactivex.c.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableRefCount<T> extends q<T> {
    RefConnection connection;
    final int n;
    final io.reactivex.d.a<T> nya;
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
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
        this.nya.subscribe(new RefCountObserver(uVar, this, refConnection));
        if (z) {
            this.nya.c(refConnection);
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
                if (this.nya instanceof io.reactivex.disposables.b) {
                    ((io.reactivex.disposables.b) this.nya).dispose();
                }
            }
        }
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                this.connection = null;
                DisposableHelper.dispose(refConnection);
                if (this.nya instanceof io.reactivex.disposables.b) {
                    ((io.reactivex.disposables.b) this.nya).dispose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements g<io.reactivex.disposables.b>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.b timer;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
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
    static final class RefCountObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -7419642935409022375L;
        final u<? super T> actual;
        final RefConnection connection;
        final ObservableRefCount<T> parent;
        io.reactivex.disposables.b upstream;

        RefCountObserver(u<? super T> uVar, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.actual = uVar;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.a(this.connection);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.actual.onSubscribe(this);
            }
        }
    }
}
