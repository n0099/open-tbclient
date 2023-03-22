package rx.internal.operators;

import com.baidu.tieba.ora;
import com.baidu.tieba.ura;
/* loaded from: classes9.dex */
public enum NeverObservableHolder implements ora.a<Object> {
    INSTANCE;
    
    public static final ora<Object> NEVER = ora.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public void call(ura<? super Object> uraVar) {
    }

    public static <T> ora<T> instance() {
        return (ora<T>) NEVER;
    }
}
