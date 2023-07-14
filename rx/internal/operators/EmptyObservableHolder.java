package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.u1c;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements u1c.a<Object> {
    INSTANCE;
    
    public static final u1c<Object> EMPTY = u1c.d(INSTANCE);

    public static <T> u1c<T> instance() {
        return (u1c<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public void call(a2c<? super Object> a2cVar) {
        a2cVar.onCompleted();
    }
}
