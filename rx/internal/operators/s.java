package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes12.dex */
public final class s<T> implements h.a<T> {
    final rx.h<T> pSV;
    final rx.functions.b<? super T> pSW;
    final rx.functions.b<Throwable> pSX;

    public s(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.pSV = hVar;
        this.pSW = bVar;
        this.pSX = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.pSW, this.pSX);
        iVar.add(aVar);
        this.pSV.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> pSW;
        final rx.functions.b<Throwable> pSX;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.pSW = bVar;
            this.pSX = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.pSW.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.pSX.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.J(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
