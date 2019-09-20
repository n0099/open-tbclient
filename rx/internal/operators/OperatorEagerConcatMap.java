package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.internal.util.a.ae;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap<T, R> implements d.b<R, T> {
    final int bufferSize;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> kyM;
    private final int kzZ;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public rx.j<? super T> call(rx.j<? super R> jVar) {
        b bVar = new b(this.kyM, this.bufferSize, this.kzZ, jVar);
        bVar.init();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class EagerOuterProducer extends AtomicLong implements rx.f {
        private static final long serialVersionUID = -657299606803478389L;
        final b<?, ?> parent;

        public EagerOuterProducer(b<?, ?> bVar) {
            this.parent = bVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            }
            if (j > 0) {
                rx.internal.operators.a.a(this, j);
                this.parent.drain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T, R> extends rx.j<T> {
        final rx.j<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        private EagerOuterProducer kAb;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> kyM;
        final Queue<a<R>> kAa = new LinkedList();
        final AtomicInteger wip = new AtomicInteger();

        public b(rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2, rx.j<? super R> jVar) {
            this.kyM = fVar;
            this.bufferSize = i;
            this.actual = jVar;
            request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : i2);
        }

        void init() {
            this.kAb = new EagerOuterProducer(this);
            add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.OperatorEagerConcatMap.b.1
                @Override // rx.functions.a
                public void call() {
                    b.this.cancelled = true;
                    if (b.this.wip.getAndIncrement() == 0) {
                        b.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.kAb);
        }

        void cleanup() {
            ArrayList<rx.k> arrayList;
            synchronized (this.kAa) {
                arrayList = new ArrayList(this.kAa);
                this.kAa.clear();
            }
            for (rx.k kVar : arrayList) {
                kVar.unsubscribe();
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                rx.d<? extends R> call = this.kyM.call(t);
                if (!this.cancelled) {
                    a<R> aVar = new a<>(this, this.bufferSize);
                    synchronized (this.kAa) {
                        if (!this.cancelled) {
                            this.kAa.add(aVar);
                            if (!this.cancelled) {
                                call.a((rx.j<? super Object>) aVar);
                                drain();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this.actual, t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void drain() {
            a<R> peek;
            if (this.wip.getAndIncrement() == 0) {
                EagerOuterProducer eagerOuterProducer = this.kAb;
                rx.j<? super R> jVar = this.actual;
                int i = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    synchronized (this.kAa) {
                        peek = this.kAa.peek();
                    }
                    boolean z2 = peek == null;
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            cleanup();
                            jVar.onError(th);
                            return;
                        } else if (z2) {
                            jVar.onCompleted();
                            return;
                        }
                    }
                    if (!z2) {
                        long j = eagerOuterProducer.get();
                        long j2 = 0;
                        Queue<Object> queue = peek.queue;
                        boolean z3 = false;
                        while (true) {
                            boolean z4 = peek.done;
                            Object peek2 = queue.peek();
                            boolean z5 = peek2 == null;
                            if (z4) {
                                Throwable th2 = peek.error;
                                if (th2 != null) {
                                    cleanup();
                                    jVar.onError(th2);
                                    return;
                                } else if (z5) {
                                    synchronized (this.kAa) {
                                        this.kAa.poll();
                                    }
                                    peek.unsubscribe();
                                    z3 = true;
                                    request(1L);
                                    break;
                                }
                            }
                            if (z5 || j == j2) {
                                break;
                            }
                            queue.poll();
                            try {
                                jVar.onNext((Object) NotificationLite.bt(peek2));
                                j2++;
                            } catch (Throwable th3) {
                                rx.exceptions.a.a(th3, jVar, peek2);
                                return;
                            }
                        }
                        if (j2 != 0) {
                            if (j != Long.MAX_VALUE) {
                                rx.internal.operators.a.b(eagerOuterProducer, j2);
                            }
                            if (!z3) {
                                peek.eU(j2);
                            }
                        }
                        if (z3) {
                            continue;
                        }
                    }
                    int addAndGet = this.wip.addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                }
                cleanup();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        volatile boolean done;
        Throwable error;
        final b<?, T> parent;
        final Queue<Object> queue;

        public a(b<?, T> bVar, int i) {
            Queue<Object> cVar;
            this.parent = bVar;
            if (ae.cRn()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            request(i);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.queue.offer(NotificationLite.bq(t));
            this.parent.drain();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        void eU(long j) {
            request(j);
        }
    }
}
