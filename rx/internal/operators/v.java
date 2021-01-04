package rx.internal.operators;

import rx.d;
import rx.h;
import rx.internal.operators.t;
/* loaded from: classes15.dex */
public final class v<T> implements d.a<T> {
    final h.a<T> quu;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public v(h.a<T> aVar) {
        this.quu = aVar;
    }

    public void call(rx.j<? super T> jVar) {
        t.a aVar = new t.a(jVar);
        jVar.add(aVar);
        this.quu.call(aVar);
    }
}
