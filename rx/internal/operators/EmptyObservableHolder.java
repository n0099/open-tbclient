package rx.internal.operators;

import com.baidu.tieba.gob;
import com.baidu.tieba.mob;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements gob.a<Object> {
    INSTANCE;
    
    public static final gob<Object> EMPTY = gob.a(INSTANCE);

    public static <T> gob<T> instance() {
        return (gob<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
    public void call(mob<? super Object> mobVar) {
        mobVar.onCompleted();
    }
}
