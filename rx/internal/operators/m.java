package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes16.dex */
public class m<T> implements d.b<T, T> {
    private final Long qge = null;
    private final rx.functions.a qgf = null;
    private final a.d qgg = rx.a.qdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class b {
        static final m<?> qgl = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> eFO() {
        return (m<T>) b.qgl;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qge, this.qgf, this.qgg);
        jVar.add(aVar);
        jVar.setProducer(aVar.eFQ());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a qgf;
        private final a.d qgg;
        private final AtomicLong qgi;
        private final BackpressureDrainManager qgk;
        private final ConcurrentLinkedQueue<Object> qgh = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qgj = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qgi = l != null ? new AtomicLong(l.longValue()) : null;
            this.qgf = aVar;
            this.qgk = new BackpressureDrainManager(this);
            this.qgg = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qgj.get()) {
                this.qgk.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qgj.get()) {
                this.qgk.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eFP()) {
                this.qgh.offer(NotificationLite.next(t));
                this.qgk.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cj(Object obj) {
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
            return this.qgh.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qgh.poll();
            if (this.qgi != null && poll != null) {
                this.qgi.incrementAndGet();
            }
            return poll;
        }

        private boolean eFP() {
            long j;
            boolean z;
            if (this.qgi == null) {
                return true;
            }
            do {
                j = this.qgi.get();
                if (j <= 0) {
                    try {
                        z = this.qgg.eFg() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qgj.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qgf != null) {
                        try {
                            this.qgf.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.qgk.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qgi.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eFQ() {
            return this.qgk;
        }
    }
}
