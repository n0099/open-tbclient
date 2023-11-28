package rx.internal.operators;

import com.baidu.tieba.eoc;
import com.baidu.tieba.koc;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements eoc.a<Object> {
    INSTANCE;
    
    public static final eoc<Object> NEVER = eoc.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.soc
    public void call(koc<? super Object> kocVar) {
    }

    public static <T> eoc<T> instance() {
        return (eoc<T>) NEVER;
    }
}
