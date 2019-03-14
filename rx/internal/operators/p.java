package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.h;
/* loaded from: classes2.dex */
public final class p<T> implements h.a<T> {
    final rx.h<T> jZh;
    final rx.functions.b<? super T> jZi;
    final rx.functions.b<Throwable> jZj;

    public p(rx.h<T> hVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.jZh = hVar;
        this.jZi = bVar;
        this.jZj = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.jZi, this.jZj);
        iVar.add(aVar);
        this.jZh.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.i<T> {
        final rx.i<? super T> actual;
        final rx.functions.b<? super T> jZi;
        final rx.functions.b<Throwable> jZj;

        a(rx.i<? super T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.actual = iVar;
            this.jZi = bVar;
            this.jZj = bVar2;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            try {
                this.jZi.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.jZj.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.L(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }
    }
}
