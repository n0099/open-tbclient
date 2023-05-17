package rx.internal.operators;

import com.baidu.tieba.h7b;
import com.baidu.tieba.n7b;
/* loaded from: classes10.dex */
public enum NeverObservableHolder implements h7b.a<Object> {
    INSTANCE;
    
    public static final h7b<Object> NEVER = h7b.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
    public void call(n7b<? super Object> n7bVar) {
    }

    public static <T> h7b<T> instance() {
        return (h7b<T>) NEVER;
    }
}
