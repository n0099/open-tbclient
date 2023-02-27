package rx.internal.operators;

import com.baidu.tieba.sma;
import com.baidu.tieba.yma;
/* loaded from: classes9.dex */
public enum EmptyObservableHolder implements sma.a<Object> {
    INSTANCE;
    
    public static final sma<Object> EMPTY = sma.a(INSTANCE);

    public static <T> sma<T> instance() {
        return (sma<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
    public void call(yma<? super Object> ymaVar) {
        ymaVar.onCompleted();
    }
}
