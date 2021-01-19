package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes14.dex */
public final class r<T> implements h.a<T> {
    final rx.h<T> qrD;
    final rx.functions.b<? super T> qrE;
    final rx.functions.b<Throwable> qrF;

    public r(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.qrD = hVar;
        this.qrE = bVar;
        this.qrF = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.qrE, this.qrF);
        iVar.add(aVar);
        this.qrD.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> qrE;
        final rx.functions.b<Throwable> qrF;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.qrE = bVar;
            this.qrF = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.qrE.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.qrF.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.O(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
