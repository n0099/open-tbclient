package rx.internal.operators;

import com.baidu.tieba.ijc;
import com.baidu.tieba.ojc;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements ijc.a<Object> {
    INSTANCE;
    
    public static final ijc<Object> NEVER = ijc.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wjc
    public void call(ojc<? super Object> ojcVar) {
    }

    public static <T> ijc<T> instance() {
        return (ijc<T>) NEVER;
    }
}
