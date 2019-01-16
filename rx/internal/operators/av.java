package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class av<T, R> implements d.b<R, T> {
    final rx.functions.f<? super T, ? extends R> iJW;
    final rx.functions.f<? super Throwable, ? extends R> iJX;
    final rx.functions.e<? extends R> iJY;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public av(rx.functions.f<? super T, ? extends R> fVar, rx.functions.f<? super Throwable, ? extends R> fVar2, rx.functions.e<? extends R> eVar) {
        this.iJW = fVar;
        this.iJX = fVar2;
        this.iJY = eVar;
    }

    public rx.j<? super T> call(rx.j<? super R> jVar) {
        final a aVar = new a(jVar, this.iJW, this.iJX, this.iJY);
        jVar.add(aVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.av.1
            @Override // rx.f
            public void request(long j) {
                aVar.dK(j);
            }
        });
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends rx.j<T> {
        final rx.j<? super R> actual;
        final rx.functions.f<? super T, ? extends R> iJW;
        final rx.functions.f<? super Throwable, ? extends R> iJX;
        final rx.functions.e<? extends R> iJY;
        long produced;
        R value;
        final AtomicLong requested = new AtomicLong();
        final AtomicLong iKb = new AtomicLong();
        final AtomicReference<rx.f> iGP = new AtomicReference<>();

        public a(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends R> fVar, rx.functions.f<? super Throwable, ? extends R> fVar2, rx.functions.e<? extends R> eVar) {
            this.actual = jVar;
            this.iJW = fVar;
            this.iJX = fVar2;
            this.iJY = eVar;
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: R, ? super R */
        @Override // rx.e
        public void onNext(T t) {
            try {
                this.produced++;
                this.actual.onNext((R) this.iJW.call(t));
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this.actual, t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            ceV();
            try {
                this.value = this.iJX.call(th);
            } catch (Throwable th2) {
                rx.exceptions.a.a(th2, this.actual, th);
            }
            ceW();
        }

        @Override // rx.e
        public void onCompleted() {
            ceV();
            try {
                this.value = this.iJY.call();
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this.actual);
            }
            ceW();
        }

        void ceV() {
            long j = this.produced;
            if (j != 0 && this.iGP.get() != null) {
                rx.internal.operators.a.b(this.requested, j);
            }
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            if (this.iGP.compareAndSet(null, fVar)) {
                long andSet = this.iKb.getAndSet(0L);
                if (andSet != 0) {
                    fVar.request(andSet);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Producer already set!");
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: R, ? super R */
        void ceW() {
            long j;
            do {
                j = this.requested.get();
                if ((j & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.requested.compareAndSet(j, j | Long.MIN_VALUE));
            if (j != 0 || this.iGP.get() == null) {
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onNext((R) this.value);
                }
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: R, ? super R */
        void dK(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j == 0) {
                return;
            }
            while (true) {
                long j2 = this.requested.get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    long j3 = Long.MAX_VALUE & j2;
                    if (this.requested.compareAndSet(j2, rx.internal.operators.a.r(j3, j) | Long.MIN_VALUE)) {
                        if (j3 == 0) {
                            if (!this.actual.isUnsubscribed()) {
                                this.actual.onNext((R) this.value);
                            }
                            if (!this.actual.isUnsubscribed()) {
                                this.actual.onCompleted();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    if (this.requested.compareAndSet(j2, rx.internal.operators.a.r(j2, j))) {
                        AtomicReference<rx.f> atomicReference = this.iGP;
                        rx.f fVar = atomicReference.get();
                        if (fVar != null) {
                            fVar.request(j);
                            return;
                        }
                        rx.internal.operators.a.a(this.iKb, j);
                        rx.f fVar2 = atomicReference.get();
                        if (fVar2 != null) {
                            long andSet = this.iKb.getAndSet(0L);
                            if (andSet != 0) {
                                fVar2.request(andSet);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }
}
