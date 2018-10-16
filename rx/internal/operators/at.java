package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public class at<T> implements d.b<T, T> {
    private final rx.functions.a iws;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public at(rx.functions.a aVar) {
        this.iws = aVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        jVar.add(rx.subscriptions.e.j(this.iws));
        return rx.b.g.b(jVar);
    }
}
