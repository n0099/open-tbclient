package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes12.dex */
public final class s<T> implements h.a<T> {
    final rx.h<T> pST;
    final rx.functions.b<? super T> pSU;
    final rx.functions.b<Throwable> pSV;

    public s(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.pST = hVar;
        this.pSU = bVar;
        this.pSV = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.pSU, this.pSV);
        iVar.add(aVar);
        this.pST.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> pSU;
        final rx.functions.b<Throwable> pSV;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.pSU = bVar;
            this.pSV = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.pSU.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.pSV.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.J(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
