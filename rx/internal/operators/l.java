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
    private final Long kyr = null;
    private final rx.functions.a kys = null;
    private final a.d kyt = rx.a.kvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kyy = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cPU() {
        return (l<T>) b.kyy;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kyr, this.kys, this.kyt);
        jVar.add(aVar);
        jVar.setProducer(aVar.cPW());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kys;
        private final a.d kyt;
        private final AtomicLong kyv;
        private final BackpressureDrainManager kyx;
        private final ConcurrentLinkedQueue<Object> kyu = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kyw = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kyv = l != null ? new AtomicLong(l.longValue()) : null;
            this.kys = aVar;
            this.kyx = new BackpressureDrainManager(this);
            this.kyt = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kyw.get()) {
                this.kyx.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kyw.get()) {
                this.kyx.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cPV()) {
                this.kyu.offer(NotificationLite.bq(t));
                this.kyx.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bz(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void Q(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.kyu.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kyu.poll();
            if (this.kyv != null && poll != null) {
                this.kyv.incrementAndGet();
            }
            return poll;
        }

        private boolean cPV() {
            long j;
            boolean z;
            if (this.kyv == null) {
                return true;
            }
            do {
                j = this.kyv.get();
                if (j <= 0) {
                    try {
                        z = this.kyt.cPg() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kyw.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kys != null) {
                        try {
                            this.kys.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.kyx.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kyv.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cPW() {
            return this.kyx;
        }
    }
}
