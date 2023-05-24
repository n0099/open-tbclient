package rx.internal.operators;

import com.baidu.tieba.i7b;
import com.baidu.tieba.o7b;
/* loaded from: classes10.dex */
public enum EmptyObservableHolder implements i7b.a<Object> {
    INSTANCE;
    
    public static final i7b<Object> EMPTY = i7b.a(INSTANCE);

    public static <T> i7b<T> instance() {
        return (i7b<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
    public void call(o7b<? super Object> o7bVar) {
        o7bVar.onCompleted();
    }
}
