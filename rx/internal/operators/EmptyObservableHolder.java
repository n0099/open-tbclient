package rx.internal.operators;

import com.baidu.tieba.kcc;
import com.baidu.tieba.qcc;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements kcc.a<Object> {
    INSTANCE;
    
    public static final kcc<Object> EMPTY = kcc.d(INSTANCE);

    public static <T> kcc<T> instance() {
        return (kcc<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
    public void call(qcc<? super Object> qccVar) {
        qccVar.onCompleted();
    }
}
