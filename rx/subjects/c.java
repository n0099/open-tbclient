package rx.subjects;

import rx.d;
import rx.e;
/* loaded from: classes2.dex */
public abstract class c<T, R> extends d<R> implements e<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(d.a<R> aVar) {
        super(aVar);
    }

    public final b<T, R> cPV() {
        return getClass() == b.class ? (b) this : new b<>(this);
    }
}
