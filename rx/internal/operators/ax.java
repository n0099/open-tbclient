package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.d;
/* loaded from: classes2.dex */
public final class ax<T> implements d.b<Notification<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ax<Object> iFQ = new ax<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ax<T> cdz() {
        return (ax<T>) a.iFQ;
    }

    ax() {
    }

    public rx.j<? super T> call(rx.j<? super Notification<T>> jVar) {
        final b bVar = new b(jVar);
        jVar.add(bVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.ax.1
            @Override // rx.f
            public void request(long j) {
                if (j > 0) {
                    bVar.dC(j);
                }
            }
        });
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<T> extends rx.j<T> {
        private final rx.j<? super Notification<T>> child;
        private volatile Notification<T> iFR;
        private boolean iFS;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();

        b(rx.j<? super Notification<T>> jVar) {
            this.child = jVar;
        }

        @Override // rx.j
        public void onStart() {
            request(0L);
        }

        void dC(long j) {
            rx.internal.operators.a.a(this.requested, j);
            request(j);
            drain();
        }

        @Override // rx.e
        public void onCompleted() {
            this.iFR = Notification.ccM();
            drain();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iFR = Notification.H(th);
            rx.c.c.onError(th);
            drain();
        }

        @Override // rx.e
        public void onNext(T t) {
            this.child.onNext(Notification.aV(t));
            cdA();
        }

        private void cdA() {
            long j;
            AtomicLong atomicLong = this.requested;
            do {
                j = atomicLong.get();
                if (j == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j - 1));
        }

        private void drain() {
            synchronized (this) {
                if (this.iFS) {
                    this.missed = true;
                    return;
                }
                AtomicLong atomicLong = this.requested;
                while (!this.child.isUnsubscribed()) {
                    Notification<T> notification = this.iFR;
                    if (notification != null && atomicLong.get() > 0) {
                        this.iFR = null;
                        this.child.onNext(notification);
                        if (!this.child.isUnsubscribed()) {
                            this.child.onCompleted();
                            return;
                        }
                        return;
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            this.iFS = false;
                            return;
                        }
                    }
                }
            }
        }
    }
}
