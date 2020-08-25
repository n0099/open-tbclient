package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes5.dex */
public class m<T> implements d.b<T, T> {
    private final Long oGe = null;
    private final rx.functions.a oGf = null;
    private final a.d oGg = rx.a.oDc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {
        static final m<?> oGl = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> ekj() {
        return (m<T>) b.oGl;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.oGe, this.oGf, this.oGg);
        jVar.add(aVar);
        jVar.setProducer(aVar.ekl());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a oGf;
        private final a.d oGg;
        private final AtomicLong oGi;
        private final BackpressureDrainManager oGk;
        private final ConcurrentLinkedQueue<Object> oGh = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean oGj = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.oGi = l != null ? new AtomicLong(l.longValue()) : null;
            this.oGf = aVar;
            this.oGk = new BackpressureDrainManager(this);
            this.oGg = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.oGj.get()) {
                this.oGk.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.oGj.get()) {
                this.oGk.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (ekk()) {
                this.oGh.offer(NotificationLite.next(t));
                this.oGk.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cc(Object obj) {
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
            return this.oGh.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.oGh.poll();
            if (this.oGi != null && poll != null) {
                this.oGi.incrementAndGet();
            }
            return poll;
        }

        private boolean ekk() {
            long j;
            boolean z;
            if (this.oGi == null) {
                return true;
            }
            do {
                j = this.oGi.get();
                if (j <= 0) {
                    try {
                        z = this.oGg.ejB() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.oGj.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.oGf != null) {
                        try {
                            this.oGf.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.oGk.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.oGi.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f ekl() {
            return this.oGk;
        }
    }
}
