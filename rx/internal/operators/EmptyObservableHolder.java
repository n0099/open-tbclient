package rx.internal.operators;

import com.baidu.tieba.eoc;
import com.baidu.tieba.koc;
/* loaded from: classes2.dex */
public enum EmptyObservableHolder implements eoc.a<Object> {
    INSTANCE;
    
    public static final eoc<Object> EMPTY = eoc.d(INSTANCE);

    public static <T> eoc<T> instance() {
        return (eoc<T>) EMPTY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.soc
    public void call(koc<? super Object> kocVar) {
        kocVar.onCompleted();
    }
}
