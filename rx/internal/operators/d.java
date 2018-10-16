package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class d<T, R> implements d.a<R> {
    final rx.d<T> isL;
    final rx.functions.e<R> itg;
    final rx.functions.c<R, ? super T> ith;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public d(rx.d<T> dVar, rx.functions.e<R> eVar, rx.functions.c<R, ? super T> cVar) {
        this.isL = dVar;
        this.itg = eVar;
        this.ith = cVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            new a(jVar, this.itg.call(), this.ith).c(this.isL);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends c<T, R> {
        final rx.functions.c<R, ? super T> ith;

        public a(rx.j<? super R> jVar, R r, rx.functions.c<R, ? super T> cVar) {
            super(jVar);
            this.value = r;
            this.hasValue = true;
            this.ith = cVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.ith.i(this.value, t);
                } catch (Throwable th) {
                    rx.exceptions.a.J(th);
                    unsubscribe();
                    onError(th);
                }
            }
        }
    }
}
