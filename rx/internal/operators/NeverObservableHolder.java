package rx.internal.operators;

import com.baidu.tieba.sac;
import com.baidu.tieba.yac;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements sac.a<Object> {
    INSTANCE;
    
    public static final sac<Object> NEVER = sac.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public void call(yac<? super Object> yacVar) {
    }

    public static <T> sac<T> instance() {
        return (sac<T>) NEVER;
    }
}
