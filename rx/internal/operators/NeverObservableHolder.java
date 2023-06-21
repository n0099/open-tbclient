package rx.internal.operators;

import com.baidu.tieba.gob;
import com.baidu.tieba.mob;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements gob.a<Object> {
    INSTANCE;
    
    public static final gob<Object> NEVER = gob.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
    public void call(mob<? super Object> mobVar) {
    }

    public static <T> gob<T> instance() {
        return (gob<T>) NEVER;
    }
}
