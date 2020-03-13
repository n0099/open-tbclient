package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes6.dex */
public final class s<T> implements h.a<T> {
    final rx.h<T> nRl;
    final rx.functions.b<? super T> nRm;
    final rx.functions.b<Throwable> nRn;

    public s(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.nRl = hVar;
        this.nRm = bVar;
        this.nRn = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.nRm, this.nRn);
        iVar.add(aVar);
        this.nRl.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> nRm;
        final rx.functions.b<Throwable> nRn;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.nRm = bVar;
            this.nRn = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.nRm.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.nRn.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.H(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
