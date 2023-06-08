package rx.internal.operators;

import com.baidu.tieba.nmb;
import com.baidu.tieba.tmb;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements nmb.a<Object> {
    INSTANCE;
    
    public static final nmb<Object> NEVER = nmb.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
    public void call(tmb<? super Object> tmbVar) {
    }

    public static <T> nmb<T> instance() {
        return (nmb<T>) NEVER;
    }
}
