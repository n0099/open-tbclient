package rx.internal.operators;

import com.baidu.tieba.f1b;
import com.baidu.tieba.l1b;
/* loaded from: classes9.dex */
public enum EmptyObservableHolder implements f1b.a<Object> {
    INSTANCE;
    
    public static final f1b<Object> EMPTY = f1b.a(INSTANCE);

    public static <T> f1b<T> instance() {
        return (f1b<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
    public void call(l1b<? super Object> l1bVar) {
        l1bVar.onCompleted();
    }
}
