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
    private final Long nly = null;
    private final rx.functions.a nlz = null;
    private final a.d nlA = rx.a.niw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nlF = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dHQ() {
        return (m<T>) b.nlF;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nly, this.nlz, this.nlA);
        jVar.add(aVar);
        jVar.setProducer(aVar.dHS());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final a.d nlA;
        private final AtomicLong nlC;
        private final BackpressureDrainManager nlE;
        private final rx.functions.a nlz;
        private final ConcurrentLinkedQueue<Object> nlB = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nlD = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nlC = l != null ? new AtomicLong(l.longValue()) : null;
            this.nlz = aVar;
            this.nlE = new BackpressureDrainManager(this);
            this.nlA = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nlD.get()) {
                this.nlE.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nlD.get()) {
                this.nlE.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dHR()) {
                this.nlB.offer(NotificationLite.next(t));
                this.nlE.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bR(Object obj) {
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
            return this.nlB.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nlB.poll();
            if (this.nlC != null && poll != null) {
                this.nlC.incrementAndGet();
            }
            return poll;
        }

        private boolean dHR() {
            long j;
            boolean z;
            if (this.nlC == null) {
                return true;
            }
            do {
                j = this.nlC.get();
                if (j <= 0) {
                    try {
                        z = this.nlA.dHi() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nlD.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nlz != null) {
                        try {
                            this.nlz.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.nlE.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nlC.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dHS() {
            return this.nlE;
        }
    }
}
