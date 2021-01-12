package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes14.dex */
public class l<T> implements d.b<T, T> {
    private final Long qqs = null;
    private final rx.functions.a qqt = null;
    private final a.d qqu = rx.a.qnr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class b {
        static final l<?> qqz = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> eKL() {
        return (l<T>) b.qqz;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qqs, this.qqt, this.qqu);
        jVar.add(aVar);
        jVar.setProducer(aVar.eKN());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a qqt;
        private final a.d qqu;
        private final AtomicLong qqw;
        private final BackpressureDrainManager qqy;
        private final ConcurrentLinkedQueue<Object> qqv = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qqx = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qqw = l != null ? new AtomicLong(l.longValue()) : null;
            this.qqt = aVar;
            this.qqy = new BackpressureDrainManager(this);
            this.qqu = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qqx.get()) {
                this.qqy.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qqx.get()) {
                this.qqy.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eKM()) {
                this.qqv.offer(NotificationLite.next(t));
                this.qqy.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cd(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void Z(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.qqv.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qqv.poll();
            if (this.qqw != null && poll != null) {
                this.qqw.incrementAndGet();
            }
            return poll;
        }

        private boolean eKM() {
            long j;
            boolean z;
            if (this.qqw == null) {
                return true;
            }
            do {
                j = this.qqw.get();
                if (j <= 0) {
                    try {
                        z = this.qqu.eKd() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qqx.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qqt != null) {
                        try {
                            this.qqt.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.O(th);
                            this.qqy.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qqw.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eKN() {
            return this.qqy;
        }
    }
}
