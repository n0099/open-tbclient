package rx.internal.operators;

import com.baidu.tieba.h7b;
import com.baidu.tieba.n7b;
/* loaded from: classes10.dex */
public enum EmptyObservableHolder implements h7b.a<Object> {
    INSTANCE;
    
    public static final h7b<Object> EMPTY = h7b.a(INSTANCE);

    public static <T> h7b<T> instance() {
        return (h7b<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
    public void call(n7b<? super Object> n7bVar) {
        n7bVar.onCompleted();
    }
}
