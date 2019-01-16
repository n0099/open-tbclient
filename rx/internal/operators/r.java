package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class r<T, R> implements d.a<R> {
    final rx.d<T> iFW;
    final rx.functions.g<R, ? super T, R> iHN;
    final R pS;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public r(rx.d<T> dVar, R r, rx.functions.g<R, ? super T, R> gVar) {
        this.iFW = dVar;
        this.pS = r;
        this.iHN = gVar;
    }

    public void call(rx.j<? super R> jVar) {
        new a(jVar, this.pS, this.iHN).c(this.iFW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends b<T, R> {
        final rx.functions.g<R, ? super T, R> iHN;

        public a(rx.j<? super R> jVar, R r, rx.functions.g<R, ? super T, R> gVar) {
            super(jVar);
            this.value = r;
            this.hasValue = true;
            this.iHN = gVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                this.value = this.iHN.j(this.value, t);
            } catch (Throwable th) {
                rx.exceptions.a.J(th);
                unsubscribe();
                this.actual.onError(th);
            }
        }
    }
}
