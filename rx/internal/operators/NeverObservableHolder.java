package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.xsb;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements xsb.a<Object> {
    INSTANCE;
    
    public static final xsb<Object> NEVER = xsb.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
    public void call(dtb<? super Object> dtbVar) {
    }

    public static <T> xsb<T> instance() {
        return (xsb<T>) NEVER;
    }
}
