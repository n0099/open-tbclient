package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes6.dex */
public class m<T> implements d.b<T, T> {
    private final Long nlv = null;
    private final rx.functions.a nlw = null;
    private final a.d nlx = rx.a.nit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nlC = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dHT() {
        return (m<T>) b.nlC;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nlv, this.nlw, this.nlx);
        jVar.add(aVar);
        jVar.setProducer(aVar.dHV());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final BackpressureDrainManager nlB;
        private final rx.functions.a nlw;
        private final a.d nlx;
        private final AtomicLong nlz;
        private final ConcurrentLinkedQueue<Object> nly = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nlA = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nlz = l != null ? new AtomicLong(l.longValue()) : null;
            this.nlw = aVar;
            this.nlB = new BackpressureDrainManager(this);
            this.nlx = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nlA.get()) {
                this.nlB.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nlA.get()) {
                this.nlB.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dHU()) {
                this.nly.offer(NotificationLite.next(t));
                this.nlB.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bQ(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void Y(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.nly.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nly.poll();
            if (this.nlz != null && poll != null) {
                this.nlz.incrementAndGet();
            }
            return poll;
        }

        private boolean dHU() {
            long j;
            boolean z;
            if (this.nlz == null) {
                return true;
            }
            do {
                j = this.nlz.get();
                if (j <= 0) {
                    try {
                        z = this.nlx.dHl() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nlA.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nlw != null) {
                        try {
                            this.nlw.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.nlB.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nlz.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dHV() {
            return this.nlB;
        }
    }
}
