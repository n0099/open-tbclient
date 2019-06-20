package rx.internal.operators;

import rx.d;
import rx.h;
import rx.internal.operators.r;
/* loaded from: classes2.dex */
public final class t<T> implements d.a<T> {
    final h.a<T> kqQ;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public t(h.a<T> aVar) {
        this.kqQ = aVar;
    }

    public void call(rx.j<? super T> jVar) {
        r.a aVar = new r.a(jVar);
        jVar.add(aVar);
        this.kqQ.call(aVar);
    }
}
