package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public class as<T> implements d.b<T, T> {
    private final rx.functions.a iyc;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public as(rx.functions.a aVar) {
        this.iyc = aVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        this.iyc.call();
        return rx.b.g.b(jVar);
    }
}
