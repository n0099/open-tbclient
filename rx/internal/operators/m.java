package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes7.dex */
public class m<T> implements d.b<T, T> {
    private final Long oQb = null;
    private final rx.functions.a oQc = null;
    private final a.d oQd = rx.a.oMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b {
        static final m<?> oQi = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> eoq() {
        return (m<T>) b.oQi;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.oQb, this.oQc, this.oQd);
        jVar.add(aVar);
        jVar.setProducer(aVar.eos());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a oQc;
        private final a.d oQd;
        private final AtomicLong oQf;
        private final BackpressureDrainManager oQh;
        private final ConcurrentLinkedQueue<Object> oQe = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean oQg = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.oQf = l != null ? new AtomicLong(l.longValue()) : null;
            this.oQc = aVar;
            this.oQh = new BackpressureDrainManager(this);
            this.oQd = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.oQg.get()) {
                this.oQh.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.oQg.get()) {
                this.oQh.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eor()) {
                this.oQe.offer(NotificationLite.next(t));
                this.oQh.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cc(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void W(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.oQe.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.oQe.poll();
            if (this.oQf != null && poll != null) {
                this.oQf.incrementAndGet();
            }
            return poll;
        }

        private boolean eor() {
            long j;
            boolean z;
            if (this.oQf == null) {
                return true;
            }
            do {
                j = this.oQf.get();
                if (j <= 0) {
                    try {
                        z = this.oQd.enH() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.oQg.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.oQc != null) {
                        try {
                            this.oQc.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.oQh.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.oQf.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eos() {
            return this.oQh;
        }
    }
}
