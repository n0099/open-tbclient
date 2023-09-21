package rx.internal.operators;

import com.baidu.tieba.kcc;
import com.baidu.tieba.qcc;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements kcc.a<Object> {
    INSTANCE;
    
    public static final kcc<Object> NEVER = kcc.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
    public void call(qcc<? super Object> qccVar) {
    }

    public static <T> kcc<T> instance() {
        return (kcc<T>) NEVER;
    }
}
