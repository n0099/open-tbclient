package rx.internal.operators;

import h.d;
import h.j;
/* loaded from: classes8.dex */
public enum NeverObservableHolder implements d.a<Object> {
    INSTANCE;
    
    public static final d<Object> NEVER = d.b(INSTANCE);

    public static <T> d<T> instance() {
        return (d<T>) NEVER;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    public void call(j<? super Object> jVar) {
    }
}
