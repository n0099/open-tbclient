package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes5.dex */
public final class d<T> implements d.a<T> {
    final rx.d<T> nMR;
    final rx.functions.f<? super T, Boolean> nNt;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public d(rx.d<T> dVar, rx.functions.f<? super T, Boolean> fVar) {
        this.nMR = dVar;
        this.nNt = fVar;
    }

    public void call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nNt);
        jVar.add(aVar);
        this.nMR.a((rx.j) aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> {
        final rx.j<? super T> actual;
        boolean done;
        final rx.functions.f<? super T, Boolean> nNt;

        public a(rx.j<? super T> jVar, rx.functions.f<? super T, Boolean> fVar) {
            this.actual = jVar;
            this.nNt = fVar;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                if (this.nNt.call(t).booleanValue()) {
                    this.actual.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                rx.exceptions.a.I(th);
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
