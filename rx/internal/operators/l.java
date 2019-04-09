package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes2.dex */
public class l<T> implements d.b<T, T> {
    private final Long jXt = null;
    private final rx.functions.a jXu = null;
    private final a.d jXv = rx.a.jUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> jXA = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cEd() {
        return (l<T>) b.jXA;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.jXt, this.jXu, this.jXv);
        jVar.add(aVar);
        jVar.setProducer(aVar.cEf());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a jXu;
        private final a.d jXv;
        private final AtomicLong jXx;
        private final BackpressureDrainManager jXz;
        private final ConcurrentLinkedQueue<Object> jXw = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean jXy = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.jXx = l != null ? new AtomicLong(l.longValue()) : null;
            this.jXu = aVar;
            this.jXz = new BackpressureDrainManager(this);
            this.jXv = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.jXy.get()) {
                this.jXz.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.jXy.get()) {
                this.jXz.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cEe()) {
                this.jXw.offer(NotificationLite.bm(t));
                this.jXz.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void R(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.jXw.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.jXw.poll();
            if (this.jXx != null && poll != null) {
                this.jXx.incrementAndGet();
            }
            return poll;
        }

        private boolean cEe() {
            long j;
            boolean z;
            if (this.jXx == null) {
                return true;
            }
            do {
                j = this.jXx.get();
                if (j <= 0) {
                    try {
                        z = this.jXv.cDq() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.jXy.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.jXu != null) {
                        try {
                            this.jXu.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.jXz.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.jXx.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cEf() {
            return this.jXz;
        }
    }
}
