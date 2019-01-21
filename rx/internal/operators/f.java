package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class f<T> implements d.a<T> {
    final rx.functions.e<? extends rx.d<? extends T>> iGF;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public f(rx.functions.e<? extends rx.d<? extends T>> eVar) {
        this.iGF = eVar;
    }

    public void call(rx.j<? super T> jVar) {
        try {
            this.iGF.call().unsafeSubscribe(rx.b.g.b(jVar));
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
        }
    }
}
