package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.x0c;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements x0c.a<Object> {
    INSTANCE;
    
    public static final x0c<Object> EMPTY = x0c.d(INSTANCE);

    public static <T> x0c<T> instance() {
        return (x0c<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
    public void call(d1c<? super Object> d1cVar) {
        d1cVar.onCompleted();
    }
}
