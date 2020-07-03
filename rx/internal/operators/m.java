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
    private final Long odv = null;
    private final rx.functions.a odw = null;
    private final a.d odx = rx.a.oar;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> odC = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dUE() {
        return (m<T>) b.odC;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.odv, this.odw, this.odx);
        jVar.add(aVar);
        jVar.setProducer(aVar.dUG());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final BackpressureDrainManager odB;
        private final rx.functions.a odw;
        private final a.d odx;
        private final AtomicLong odz;
        private final ConcurrentLinkedQueue<Object> ody = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean odA = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.odz = l != null ? new AtomicLong(l.longValue()) : null;
            this.odw = aVar;
            this.odB = new BackpressureDrainManager(this);
            this.odx = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.odA.get()) {
                this.odB.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.odA.get()) {
                this.odB.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dUF()) {
                this.ody.offer(NotificationLite.next(t));
                this.odB.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bY(Object obj) {
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
            return this.ody.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.ody.poll();
            if (this.odz != null && poll != null) {
                this.odz.incrementAndGet();
            }
            return poll;
        }

        private boolean dUF() {
            long j;
            boolean z;
            if (this.odz == null) {
                return true;
            }
            do {
                j = this.odz.get();
                if (j <= 0) {
                    try {
                        z = this.odx.dTW() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.odA.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.odw != null) {
                        try {
                            this.odw.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.odB.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.odz.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dUG() {
            return this.odB;
        }
    }
}
