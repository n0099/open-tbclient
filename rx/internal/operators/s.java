package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes6.dex */
public final class s<T> implements h.a<T> {
    final rx.h<T> onr;
    final rx.functions.b<? super T> ons;
    final rx.functions.b<Throwable> ont;

    public s(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.onr = hVar;
        this.ons = bVar;
        this.ont = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.ons, this.ont);
        iVar.add(aVar);
        this.onr.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> ons;
        final rx.functions.b<Throwable> ont;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.ons = bVar;
            this.ont = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.ons.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.ont.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.K(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
