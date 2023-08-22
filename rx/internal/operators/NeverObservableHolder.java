package rx.internal.operators;

import com.baidu.tieba.n7c;
import com.baidu.tieba.t7c;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements n7c.a<Object> {
    INSTANCE;
    
    public static final n7c<Object> NEVER = n7c.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public void call(t7c<? super Object> t7cVar) {
    }

    public static <T> n7c<T> instance() {
        return (n7c<T>) NEVER;
    }
}
