package rx.internal.operators;

import com.baidu.tieba.jjc;
import com.baidu.tieba.pjc;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements jjc.a<Object> {
    INSTANCE;
    
    public static final jjc<Object> EMPTY = jjc.d(INSTANCE);

    public static <T> jjc<T> instance() {
        return (jjc<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xjc
    public void call(pjc<? super Object> pjcVar) {
        pjcVar.onCompleted();
    }
}
