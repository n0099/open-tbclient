package rx.internal.operators;

import com.baidu.tieba.sma;
import com.baidu.tieba.yma;
/* loaded from: classes9.dex */
public enum NeverObservableHolder implements sma.a<Object> {
    INSTANCE;
    
    public static final sma<Object> NEVER = sma.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
    public void call(yma<? super Object> ymaVar) {
    }

    public static <T> sma<T> instance() {
        return (sma<T>) NEVER;
    }
}
