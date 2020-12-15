package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes12.dex */
public final class f<T, R> implements d.a<R> {
    final rx.d<T> pPC;
    final rx.functions.f<? super T, ? extends R> pQA;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public f(rx.d<T> dVar, rx.functions.f<? super T, ? extends R> fVar) {
        this.pPC = dVar;
        this.pQA = fVar;
    }

    public void call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.pQA);
        jVar.add(aVar);
        this.pPC.a((rx.j) aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a<T, R> extends rx.j<T> {
        final rx.j<? super R> actual;
        boolean done;
        final rx.functions.f<? super T, ? extends R> pPU;

        public a(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends R> fVar) {
            this.actual = jVar;
            this.pPU = fVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                this.actual.onNext(this.pPU.call(t));
            } catch (Throwable th) {
                rx.exceptions.a.J(th);
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
