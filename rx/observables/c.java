package rx.observables;

import rx.d;
import rx.internal.operators.s;
import rx.k;
/* loaded from: classes2.dex */
public abstract class c<T> extends rx.d<T> {
    public abstract void c(rx.functions.b<? super k> bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(d.a<T> aVar) {
        super(aVar);
    }

    public rx.d<T> cdj() {
        return create(new s(this));
    }
}
