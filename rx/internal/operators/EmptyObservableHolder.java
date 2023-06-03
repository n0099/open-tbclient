package rx.internal.operators;

import com.baidu.tieba.imb;
import com.baidu.tieba.omb;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements imb.a<Object> {
    INSTANCE;
    
    public static final imb<Object> EMPTY = imb.a(INSTANCE);

    public static <T> imb<T> instance() {
        return (imb<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
    public void call(omb<? super Object> ombVar) {
        ombVar.onCompleted();
    }
}
