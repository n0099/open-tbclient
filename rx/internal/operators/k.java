package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes2.dex */
public final class k<T> implements d.a<T> {
    final rx.d<T> isL;
    final rx.functions.f<? super T, Boolean> itG;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public k(rx.d<T> dVar, rx.functions.f<? super T, Boolean> fVar) {
        this.isL = dVar;
        this.itG = fVar;
    }

    public void call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.itG);
        jVar.add(aVar);
        this.isL.unsafeSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        final rx.j<? super T> actual;
        boolean done;
        final rx.functions.f<? super T, Boolean> itG;

        public a(rx.j<? super T> jVar, rx.functions.f<? super T, Boolean> fVar) {
            this.actual = jVar;
            this.itG = fVar;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                if (this.itG.call(t).booleanValue()) {
                    this.actual.onNext(t);
                } else {
                    request(1L);
                }
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
            super.setProducer(fVar);
            this.actual.setProducer(fVar);
        }
    }
}
