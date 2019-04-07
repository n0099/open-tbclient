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
    private final Long jXs = null;
    private final rx.functions.a jXt = null;
    private final a.d jXu = rx.a.jUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> jXz = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cEd() {
        return (l<T>) b.jXz;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.jXs, this.jXt, this.jXu);
        jVar.add(aVar);
        jVar.setProducer(aVar.cEf());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a jXt;
        private final a.d jXu;
        private final AtomicLong jXw;
        private final BackpressureDrainManager jXy;
        private final ConcurrentLinkedQueue<Object> jXv = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean jXx = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.jXw = l != null ? new AtomicLong(l.longValue()) : null;
            this.jXt = aVar;
            this.jXy = new BackpressureDrainManager(this);
            this.jXu = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.jXx.get()) {
                this.jXy.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.jXx.get()) {
                this.jXy.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cEe()) {
                this.jXv.offer(NotificationLite.bm(t));
                this.jXy.drain();
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
            return this.jXv.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.jXv.poll();
            if (this.jXw != null && poll != null) {
                this.jXw.incrementAndGet();
            }
            return poll;
        }

        private boolean cEe() {
            long j;
            boolean z;
            if (this.jXw == null) {
                return true;
            }
            do {
                j = this.jXw.get();
                if (j <= 0) {
                    try {
                        z = this.jXu.cDq() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.jXx.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.jXt != null) {
                        try {
                            this.jXt.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.jXy.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.jXw.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cEf() {
            return this.jXy;
        }
    }
}
