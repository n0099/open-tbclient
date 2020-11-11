package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes16.dex */
public final class d<T> implements d.a<T> {
    final rx.d<T> qdV;
    final rx.functions.f<? super T, Boolean> qex;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public d(rx.d<T> dVar, rx.functions.f<? super T, Boolean> fVar) {
        this.qdV = dVar;
        this.qex = fVar;
    }

    public void call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qex);
        jVar.add(aVar);
        this.qdV.a((rx.j) aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class a<T> extends rx.j<T> {
        final rx.j<? super T> actual;
        boolean done;
        final rx.functions.f<? super T, Boolean> qex;

        public a(rx.j<? super T> jVar, rx.functions.f<? super T, Boolean> fVar) {
            this.actual = jVar;
            this.qex = fVar;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                if (this.qex.call(t).booleanValue()) {
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
