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
    private final Long kBr = null;
    private final rx.functions.a kBs = null;
    private final a.d kBt = rx.a.kyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kBy = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cOL() {
        return (l<T>) b.kBy;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kBr, this.kBs, this.kBt);
        jVar.add(aVar);
        jVar.setProducer(aVar.cON());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kBs;
        private final a.d kBt;
        private final AtomicLong kBv;
        private final BackpressureDrainManager kBx;
        private final ConcurrentLinkedQueue<Object> kBu = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kBw = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kBv = l != null ? new AtomicLong(l.longValue()) : null;
            this.kBs = aVar;
            this.kBx = new BackpressureDrainManager(this);
            this.kBt = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kBw.get()) {
                this.kBx.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kBw.get()) {
                this.kBx.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cOM()) {
                this.kBu.offer(NotificationLite.bl(t));
                this.kBx.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bu(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void P(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.kBu.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kBu.poll();
            if (this.kBv != null && poll != null) {
                this.kBv.incrementAndGet();
            }
            return poll;
        }

        private boolean cOM() {
            long j;
            boolean z;
            if (this.kBv == null) {
                return true;
            }
            do {
                j = this.kBv.get();
                if (j <= 0) {
                    try {
                        z = this.kBt.cNZ() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kBw.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kBs != null) {
                        try {
                            this.kBs.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.kBx.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kBv.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cON() {
            return this.kBx;
        }
    }
}
