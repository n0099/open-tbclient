package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes5.dex */
public final class r<T> implements h.a<T> {
    final rx.h<T> qBG;
    final rx.functions.b<? super T> qBH;
    final rx.functions.b<Throwable> qBI;

    public r(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.qBG = hVar;
        this.qBH = bVar;
        this.qBI = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.qBH, this.qBI);
        iVar.add(aVar);
        this.qBG.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> qBH;
        final rx.functions.b<Throwable> qBI;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.qBH = bVar;
            this.qBI = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.qBH.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.qBI.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.N(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
