package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes5.dex */
public final class s<T> implements h.a<T> {
    final rx.h<T> nQe;
    final rx.functions.b<? super T> nQf;
    final rx.functions.b<Throwable> nQg;

    public s(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.nQe = hVar;
        this.nQf = bVar;
        this.nQg = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.nQf, this.nQg);
        iVar.add(aVar);
        this.nQe.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> nQf;
        final rx.functions.b<Throwable> nQg;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.nQf = bVar;
            this.nQg = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.nQf.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.nQg.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.I(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
