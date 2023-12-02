package rx.internal.operators;

import com.baidu.tieba.doc;
import com.baidu.tieba.joc;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements doc.a<Object> {
    INSTANCE;
    
    public static final doc<Object> NEVER = doc.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.roc
    public void call(joc<? super Object> jocVar) {
    }

    public static <T> doc<T> instance() {
        return (doc<T>) NEVER;
    }
}
