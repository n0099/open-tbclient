package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes12.dex */
public final class d<T> implements d.a<T> {
    final rx.d<T> pPC;
    final rx.functions.f<? super T, Boolean> pQe;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public d(rx.d<T> dVar, rx.functions.f<? super T, Boolean> fVar) {
        this.pPC = dVar;
        this.pQe = fVar;
    }

    public void call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.pQe);
        jVar.add(aVar);
        this.pPC.a((rx.j) aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a<T> extends rx.j<T> {
        final rx.j<? super T> actual;
        boolean done;
        final rx.functions.f<? super T, Boolean> pQe;

        public a(rx.j<? super T> jVar, rx.functions.f<? super T, Boolean> fVar) {
            this.actual = jVar;
            this.pQe = fVar;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                if (this.pQe.call(t).booleanValue()) {
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
