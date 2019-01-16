package rx.internal.operators;

import rx.d;
import rx.h;
import rx.internal.operators.cr;
/* loaded from: classes2.dex */
public final class ct<T> implements d.a<T> {
    final h.a<T> iOz;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public ct(h.a<T> aVar) {
        this.iOz = aVar;
    }

    public void call(rx.j<? super T> jVar) {
        cr.a aVar = new cr.a(jVar);
        jVar.add(aVar);
        this.iOz.call(aVar);
    }
}
