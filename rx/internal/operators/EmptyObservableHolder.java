package rx.internal.operators;

import com.baidu.tieba.nmb;
import com.baidu.tieba.tmb;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements nmb.a<Object> {
    INSTANCE;
    
    public static final nmb<Object> EMPTY = nmb.a(INSTANCE);

    public static <T> nmb<T> instance() {
        return (nmb<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
    public void call(tmb<? super Object> tmbVar) {
        tmbVar.onCompleted();
    }
}
