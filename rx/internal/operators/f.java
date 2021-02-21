package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes5.dex */
public final class f<T, R> implements d.a<R> {
    final rx.d<T> qyO;
    final rx.functions.f<? super T, ? extends R> qzM;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public f(rx.d<T> dVar, rx.functions.f<? super T, ? extends R> fVar) {
        this.qyO = dVar;
        this.qzM = fVar;
    }

    public void call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.qzM);
        jVar.add(aVar);
        this.qyO.a((rx.j) aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T, R> extends rx.j<T> {
        final rx.j<? super R> actual;
        boolean done;
        final rx.functions.f<? super T, ? extends R> qzg;

        public a(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends R> fVar) {
            this.actual = jVar;
            this.qzg = fVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                this.actual.onNext(this.qzg.call(t));
            } catch (Throwable th) {
                rx.exceptions.a.N(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.done) {
                rx.c.c.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.actual.onCompleted();
            }
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.actual.setProducer(fVar);
        }
    }
}
