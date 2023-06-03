package rx.internal.operators;

import com.baidu.tieba.imb;
import com.baidu.tieba.omb;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements imb.a<Object> {
    INSTANCE;
    
    public static final imb<Object> NEVER = imb.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
    public void call(omb<? super Object> ombVar) {
    }

    public static <T> imb<T> instance() {
        return (imb<T>) NEVER;
    }
}
