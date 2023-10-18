package rx.internal.operators;

import com.baidu.tieba.h6c;
import com.baidu.tieba.n6c;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements h6c.a<Object> {
    INSTANCE;
    
    public static final h6c<Object> NEVER = h6c.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v6c
    public void call(n6c<? super Object> n6cVar) {
    }

    public static <T> h6c<T> instance() {
        return (h6c<T>) NEVER;
    }
}
