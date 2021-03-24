package rx.internal.operators;

import h.d;
import h.j;
/* loaded from: classes7.dex */
public enum EmptyObservableHolder implements d.a<Object> {
    INSTANCE;
    
    public static final d<Object> EMPTY = d.c(INSTANCE);

    public static <T> d<T> instance() {
        return (d<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    public void call(j<? super Object> jVar) {
        jVar.onCompleted();
    }
}
