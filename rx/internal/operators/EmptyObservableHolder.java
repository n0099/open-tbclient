package rx.internal.operators;

import com.baidu.tieba.ora;
import com.baidu.tieba.ura;
/* loaded from: classes9.dex */
public enum EmptyObservableHolder implements ora.a<Object> {
    INSTANCE;
    
    public static final ora<Object> EMPTY = ora.a(INSTANCE);

    public static <T> ora<T> instance() {
        return (ora<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public void call(ura<? super Object> uraVar) {
        uraVar.onCompleted();
    }
}
