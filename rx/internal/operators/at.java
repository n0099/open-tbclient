package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public class at<T> implements d.b<T, T> {
    private final rx.functions.a iFl;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public at(rx.functions.a aVar) {
        this.iFl = aVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        jVar.add(rx.subscriptions.e.j(this.iFl));
        return rx.b.g.b(jVar);
    }
}
