package rx.internal.operators;

import rx.d;
/* loaded from: classes4.dex */
public enum NeverObservableHolder implements d.a<Object> {
    INSTANCE;
    
    static final rx.d<Object> NEVER = rx.d.a((d.a) INSTANCE);

    public static <T> rx.d<T> instance() {
        return (rx.d<T>) NEVER;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    public void call(rx.j<? super Object> jVar) {
    }
}
