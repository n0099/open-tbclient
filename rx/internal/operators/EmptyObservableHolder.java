package rx.internal.operators;

import com.baidu.tieba.ijc;
import com.baidu.tieba.ojc;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements ijc.a<Object> {
    INSTANCE;
    
    public static final ijc<Object> EMPTY = ijc.d(INSTANCE);

    public static <T> ijc<T> instance() {
        return (ijc<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wjc
    public void call(ojc<? super Object> ojcVar) {
        ojcVar.onCompleted();
    }
}
