package rx.internal.operators;

import com.baidu.tieba.e1c;
import com.baidu.tieba.y0c;
/* loaded from: classes2.dex */
public enum NeverObservableHolder implements y0c.a<Object> {
    INSTANCE;
    
    public static final y0c<Object> NEVER = y0c.d(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
    public void call(e1c<? super Object> e1cVar) {
    }

    public static <T> y0c<T> instance() {
        return (y0c<T>) NEVER;
    }
}
