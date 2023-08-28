package rx.internal.operators;

import com.baidu.tieba.p7c;
import com.baidu.tieba.v7c;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements p7c.a<Object> {
    INSTANCE;
    
    public static final p7c<Object> EMPTY = p7c.d(INSTANCE);

    public static <T> p7c<T> instance() {
        return (p7c<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public void call(v7c<? super Object> v7cVar) {
        v7cVar.onCompleted();
    }
}
