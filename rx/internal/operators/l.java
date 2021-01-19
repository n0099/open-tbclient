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
    private final Long qqt = null;
    private final rx.functions.a qqu = null;
    private final a.d qqv = rx.a.qns;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class b {
        static final l<?> qqA = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> eKL() {
        return (l<T>) b.qqA;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qqt, this.qqu, this.qqv);
        jVar.add(aVar);
        jVar.setProducer(aVar.eKN());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a qqu;
        private final a.d qqv;
        private final AtomicLong qqx;
        private final BackpressureDrainManager qqz;
        private final ConcurrentLinkedQueue<Object> qqw = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qqy = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qqx = l != null ? new AtomicLong(l.longValue()) : null;
            this.qqu = aVar;
            this.qqz = new BackpressureDrainManager(this);
            this.qqv = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qqy.get()) {
                this.qqz.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qqy.get()) {
                this.qqz.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eKM()) {
                this.qqw.offer(NotificationLite.next(t));
                this.qqz.drain();
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
            return this.qqw.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qqw.poll();
            if (this.qqx != null && poll != null) {
                this.qqx.incrementAndGet();
            }
            return poll;
        }

        private boolean eKM() {
            long j;
            boolean z;
            if (this.qqx == null) {
                return true;
            }
            do {
                j = this.qqx.get();
                if (j <= 0) {
                    try {
                        z = this.qqv.eKd() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qqy.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qqu != null) {
                        try {
                            this.qqu.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.O(th);
                            this.qqz.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qqx.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eKN() {
            return this.qqz;
        }
    }
}
