package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class OperatorZip<R> implements d.b<R, rx.d<?>[]> {
    final rx.functions.j<? extends R> zipFunction;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public rx.j<? super rx.d[]> call(rx.j<? super R> jVar) {
        Zip zip = new Zip(jVar, this.zipFunction);
        ZipProducer zipProducer = new ZipProducer(zip);
        a aVar = new a(jVar, zip, zipProducer);
        jVar.add(aVar);
        jVar.setProducer(zipProducer);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a extends rx.j<rx.d[]> {
        final rx.j<? super R> child;
        final ZipProducer<R> nmE;
        boolean started;
        final Zip<R> zipper;

        public a(rx.j<? super R> jVar, Zip<R> zip, ZipProducer<R> zipProducer) {
            this.child = jVar;
            this.zipper = zip;
            this.nmE = zipProducer;
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.started) {
                this.child.onCompleted();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.child.onError(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(rx.d[] dVarArr) {
            if (dVarArr == null || dVarArr.length == 0) {
                this.child.onCompleted();
                return;
            }
            this.started = true;
            this.zipper.start(dVarArr, this.nmE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ZipProducer<R> extends AtomicLong implements rx.f {
        private static final long serialVersionUID = -1216676403723546796L;
        final Zip<R> zipper;

        public ZipProducer(Zip<R> zip) {
            this.zipper = zip;
        }

        @Override // rx.f
        public void request(long j) {
            rx.internal.operators.a.e(this, j);
            this.zipper.tick();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Zip<R> extends AtomicLong {
        static final int THRESHOLD = (int) (rx.internal.util.g.SIZE * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        final rx.e<? super R> child;
        private final rx.subscriptions.b childSubscription = new rx.subscriptions.b();
        int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final rx.functions.j<? extends R> zipFunction;

        public Zip(rx.j<? super R> jVar, rx.functions.j<? extends R> jVar2) {
            this.child = jVar;
            this.zipFunction = jVar2;
            jVar.add(this.childSubscription);
        }

        public void start(rx.d[] dVarArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[dVarArr.length];
            for (int i = 0; i < dVarArr.length; i++) {
                a aVar = new a();
                objArr[i] = aVar;
                this.childSubscription.add(aVar);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                dVarArr[i2].a((rx.j) ((a) objArr[i2]));
            }
        }

        /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: R, ? super R */
        void tick() {
            boolean z;
            Object[] objArr = this.subscribers;
            if (objArr != null && getAndIncrement() == 0) {
                int length = objArr.length;
                rx.e<? super R> eVar = this.child;
                AtomicLong atomicLong = this.requested;
                while (true) {
                    Object[] objArr2 = new Object[length];
                    boolean z2 = true;
                    int i = 0;
                    while (i < length) {
                        rx.internal.util.g gVar = ((a) objArr[i]).nmC;
                        Object peek = gVar.peek();
                        if (peek == null) {
                            z = false;
                        } else if (gVar.bO(peek)) {
                            eVar.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        } else {
                            objArr2[i] = gVar.getValue(peek);
                            z = z2;
                        }
                        i++;
                        z2 = z;
                    }
                    if (z2 && atomicLong.get() > 0) {
                        try {
                            eVar.onNext((R) this.zipFunction.call(objArr2));
                            atomicLong.decrementAndGet();
                            this.emitted++;
                            for (Object obj : objArr) {
                                rx.internal.util.g gVar2 = ((a) obj).nmC;
                                gVar2.poll();
                                if (gVar2.bO(gVar2.peek())) {
                                    eVar.onCompleted();
                                    this.childSubscription.unsubscribe();
                                    return;
                                }
                            }
                            if (this.emitted > THRESHOLD) {
                                for (Object obj2 : objArr) {
                                    ((a) obj2).requestMore(this.emitted);
                                }
                                this.emitted = 0;
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, eVar, objArr2);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public final class a extends rx.j {
            final rx.internal.util.g nmC = rx.internal.util.g.dIf();

            a() {
            }

            @Override // rx.j
            public void onStart() {
                request(rx.internal.util.g.SIZE);
            }

            public void requestMore(long j) {
                request(j);
            }

            @Override // rx.e
            public void onCompleted() {
                this.nmC.onCompleted();
                Zip.this.tick();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                Zip.this.child.onError(th);
            }

            @Override // rx.e
            public void onNext(Object obj) {
                try {
                    this.nmC.onNext(obj);
                } catch (MissingBackpressureException e) {
                    onError(e);
                }
                Zip.this.tick();
            }
        }
    }
}
