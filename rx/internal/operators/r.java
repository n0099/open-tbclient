package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes15.dex */
public final class r<T> implements h.a<T> {
    final rx.h<T> qwe;
    final rx.functions.b<? super T> qwf;
    final rx.functions.b<Throwable> qwg;

    public r(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.qwe = hVar;
        this.qwf = bVar;
        this.qwg = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.qwf, this.qwg);
        iVar.add(aVar);
        this.qwe.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> qwf;
        final rx.functions.b<Throwable> qwg;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.qwf = bVar;
            this.qwg = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.qwf.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.qwg.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.O(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
