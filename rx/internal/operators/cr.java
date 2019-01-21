package rx.internal.operators;

import rx.d;
import rx.h;
import rx.internal.operators.cq;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class cr<T, R> implements h.a<R> {
    final h.a<T> iOA;
    final d.b<? extends R, ? super T> iOG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super R> iVar) {
        cq.a aVar = new cq.a(iVar);
        iVar.add(aVar);
        try {
            rx.j<? super T> call = rx.c.c.b(this.iOG).call(aVar);
            rx.i a2 = a(call);
            call.onStart();
            this.iOA.call(a2);
        } catch (Throwable th) {
            rx.exceptions.a.a(th, iVar);
        }
    }

    public static <T> rx.i<T> a(rx.j<T> jVar) {
        a aVar = new a(jVar);
        jVar.add(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.j<? super T> actual;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.j<? super T> jVar) {
            this.actual = jVar;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            this.actual.setProducer(new SingleProducer(this.actual, t));
        }

        @Override // rx.i
        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }
}
