package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes2.dex */
public final class p<T> implements h.a<T> {
    final rx.h<T> kqQ;
    final rx.functions.b<? super T> kqR;
    final rx.functions.b<Throwable> kqS;

    public p(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.kqQ = hVar;
        this.kqR = bVar;
        this.kqS = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.kqR, this.kqS);
        iVar.add(aVar);
        this.kqQ.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> kqR;
        final rx.functions.b<Throwable> kqS;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.kqR = bVar;
            this.kqS = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.kqR.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.kqS.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.K(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
