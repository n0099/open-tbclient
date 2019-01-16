package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.d;
/* loaded from: classes2.dex */
public final class ax<T> implements d.b<Notification<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ax<Object> iKh = new ax<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ax<T> ceX() {
        return (ax<T>) a.iKh;
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
                    bVar.dH(j);
                }
            }
        });
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<T> extends rx.j<T> {
        private final rx.j<? super Notification<T>> child;
        private volatile Notification<T> iKi;
        private boolean iKj;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();

        b(rx.j<? super Notification<T>> jVar) {
            this.child = jVar;
        }

        @Override // rx.j
        public void onStart() {
            request(0L);
        }

        void dH(long j) {
            rx.internal.operators.a.a(this.requested, j);
            request(j);
            drain();
        }

        @Override // rx.e
        public void onCompleted() {
            this.iKi = Notification.cek();
            drain();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iKi = Notification.H(th);
            rx.c.c.onError(th);
            drain();
        }

        @Override // rx.e
        public void onNext(T t) {
            this.child.onNext(Notification.aV(t));
            ceY();
        }

        private void ceY() {
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
                if (this.iKj) {
                    this.missed = true;
                    return;
                }
                AtomicLong atomicLong = this.requested;
                while (!this.child.isUnsubscribed()) {
                    Notification<T> notification = this.iKi;
                    if (notification != null && atomicLong.get() > 0) {
                        this.iKi = null;
                        this.child.onNext(notification);
                        if (!this.child.isUnsubscribed()) {
                            this.child.onCompleted();
                            return;
                        }
                        return;
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            this.iKj = false;
                            return;
                        }
                    }
                }
            }
        }
    }
}
