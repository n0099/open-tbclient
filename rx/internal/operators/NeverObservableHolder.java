package rx.internal.operators;

import com.baidu.tieba.n1b;
import com.baidu.tieba.t1b;
/* loaded from: classes9.dex */
public enum NeverObservableHolder implements n1b.a<Object> {
    INSTANCE;
    
    public static final n1b<Object> NEVER = n1b.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
    public void call(t1b<? super Object> t1bVar) {
    }

    public static <T> n1b<T> instance() {
        return (n1b<T>) NEVER;
    }
}
