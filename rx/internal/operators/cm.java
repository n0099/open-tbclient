package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.d;
/* loaded from: classes2.dex */
public final class cm<T, R> implements d.a<R> {
    final rx.functions.o<R> combiner;
    final rx.d<T> iGI;
    final rx.d<?>[] iOn;
    final Iterable<rx.d<?>> iOo;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public cm(rx.d<T> dVar, rx.d<?>[] dVarArr, Iterable<rx.d<?>> iterable, rx.functions.o<R> oVar) {
        this.iGI = dVar;
        this.iOn = dVarArr;
        this.iOo = iterable;
        this.combiner = oVar;
    }

    public void call(rx.j<? super R> jVar) {
        int i;
        rx.d<?>[] dVarArr;
        rx.b.f fVar = new rx.b.f(jVar);
        if (this.iOn != null) {
            dVarArr = this.iOn;
            i = dVarArr.length;
        } else {
            i = 0;
            dVarArr = new rx.d[8];
            for (rx.d<?> dVar : this.iOo) {
                if (i == dVarArr.length) {
                    dVarArr = (rx.d[]) Arrays.copyOf(dVarArr, (i >> 2) + i);
                }
                rx.d<?>[] dVarArr2 = dVarArr;
                dVarArr2[i] = dVar;
                i++;
                dVarArr = dVarArr2;
            }
        }
        a aVar = new a(jVar, this.combiner, i);
        fVar.add(aVar);
        for (int i2 = 0; i2 < i; i2++) {
            if (!fVar.isUnsubscribed()) {
                b bVar = new b(aVar, i2 + 1);
                aVar.add(bVar);
                dVarArr[i2].unsafeSubscribe(bVar);
            } else {
                return;
            }
        }
        this.iGI.unsafeSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends rx.j<T> {
        static final Object EMPTY = new Object();
        final rx.j<? super R> actual;
        final rx.functions.o<R> combiner;
        boolean done;
        final AtomicReferenceArray<Object> iOp;
        final AtomicInteger iOq;

        public a(rx.j<? super R> jVar, rx.functions.o<R> oVar, int i) {
            this.actual = jVar;
            this.combiner = oVar;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i + 1);
            for (int i2 = 0; i2 <= i; i2++) {
                atomicReferenceArray.lazySet(i2, EMPTY);
            }
            this.iOp = atomicReferenceArray;
            this.iOq = new AtomicInteger(i);
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                if (this.iOq.get() == 0) {
                    AtomicReferenceArray<Object> atomicReferenceArray = this.iOp;
                    int length = atomicReferenceArray.length();
                    atomicReferenceArray.lazySet(0, t);
                    Object[] objArr = new Object[atomicReferenceArray.length()];
                    for (int i = 0; i < length; i++) {
                        objArr[i] = atomicReferenceArray.get(i);
                    }
                    try {
                        this.actual.onNext(this.combiner.call(objArr));
                        return;
                    } catch (Throwable th) {
                        rx.exceptions.a.J(th);
                        onError(th);
                        return;
                    }
                }
                request(1L);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.done) {
                rx.c.c.onError(th);
                return;
            }
            this.done = true;
            unsubscribe();
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                unsubscribe();
                this.actual.onCompleted();
            }
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            super.setProducer(fVar);
            this.actual.setProducer(fVar);
        }

        void d(int i, Object obj) {
            if (this.iOp.getAndSet(i, obj) == EMPTY) {
                this.iOq.decrementAndGet();
            }
        }

        void c(int i, Throwable th) {
            onError(th);
        }

        void zD(int i) {
            if (this.iOp.get(i) == EMPTY) {
                onCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b extends rx.j<Object> {
        final a<?, ?> iOr;
        final int index;

        public b(a<?, ?> aVar, int i) {
            this.iOr = aVar;
            this.index = i;
        }

        @Override // rx.e
        public void onNext(Object obj) {
            this.iOr.d(this.index, obj);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iOr.c(this.index, th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.iOr.zD(this.index);
        }
    }
}
