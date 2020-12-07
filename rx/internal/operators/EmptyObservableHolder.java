package rx.internal.operators;

import rx.d;
/* loaded from: classes12.dex */
public enum EmptyObservableHolder implements d.a<Object> {
    INSTANCE;
    
    static final rx.d<Object> EMPTY = rx.d.a((d.a) INSTANCE);

    public static <T> rx.d<T> instance() {
        return (rx.d<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    public void call(rx.j<? super Object> jVar) {
        jVar.onCompleted();
    }
}
