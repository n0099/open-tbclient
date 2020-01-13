package rx.internal.operators;

import rx.d;
import rx.h;
import rx.internal.operators.u;
/* loaded from: classes5.dex */
public final class w<T> implements d.a<T> {
    final h.a<T> nQc;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public w(h.a<T> aVar) {
        this.nQc = aVar;
    }

    public void call(rx.j<? super T> jVar) {
        u.a aVar = new u.a(jVar);
        jVar.add(aVar);
        this.nQc.call(aVar);
    }
}
