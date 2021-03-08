package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes4.dex */
public final class r<T> implements h.a<T> {
    final rx.h<T> qCI;
    final rx.functions.b<? super T> qCJ;
    final rx.functions.b<Throwable> qCK;

    public r(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.qCI = hVar;
        this.qCJ = bVar;
        this.qCK = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.qCJ, this.qCK);
        iVar.add(aVar);
        this.qCI.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> qCJ;
        final rx.functions.b<Throwable> qCK;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.qCJ = bVar;
            this.qCK = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.qCJ.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.qCK.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.N(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
