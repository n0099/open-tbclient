package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes6.dex */
public final class s<T> implements h.a<T> {
    final rx.h<T> nQY;
    final rx.functions.b<? super T> nQZ;
    final rx.functions.b<Throwable> nRa;

    public s(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.nQY = hVar;
        this.nQZ = bVar;
        this.nRa = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.nQZ, this.nRa);
        iVar.add(aVar);
        this.nQY.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> nQZ;
        final rx.functions.b<Throwable> nRa;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.nQZ = bVar;
            this.nRa = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.nQZ.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.nRa.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.H(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
