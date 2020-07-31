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
    private final Long omg = null;
    private final rx.functions.a omh = null;
    private final a.d omi = rx.a.oje;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> omn = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dYe() {
        return (m<T>) b.omn;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.omg, this.omh, this.omi);
        jVar.add(aVar);
        jVar.setProducer(aVar.dYg());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a omh;
        private final a.d omi;
        private final AtomicLong omk;
        private final BackpressureDrainManager omm;
        private final ConcurrentLinkedQueue<Object> omj = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean oml = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.omk = l != null ? new AtomicLong(l.longValue()) : null;
            this.omh = aVar;
            this.omm = new BackpressureDrainManager(this);
            this.omi = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.oml.get()) {
                this.omm.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.oml.get()) {
                this.omm.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dYf()) {
                this.omj.offer(NotificationLite.next(t));
                this.omm.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bY(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void X(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.omj.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.omj.poll();
            if (this.omk != null && poll != null) {
                this.omk.incrementAndGet();
            }
            return poll;
        }

        private boolean dYf() {
            long j;
            boolean z;
            if (this.omk == null) {
                return true;
            }
            do {
                j = this.omk.get();
                if (j <= 0) {
                    try {
                        z = this.omi.dXw() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.oml.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.omh != null) {
                        try {
                            this.omh.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.omm.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.omk.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dYg() {
            return this.omm;
        }
    }
}
