package rx.internal.operators;

import com.baidu.tieba.j5b;
import com.baidu.tieba.p5b;
/* loaded from: classes9.dex */
public enum NeverObservableHolder implements j5b.a<Object> {
    INSTANCE;
    
    public static final j5b<Object> NEVER = j5b.a(INSTANCE);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public void call(p5b<? super Object> p5bVar) {
    }

    public static <T> j5b<T> instance() {
        return (j5b<T>) NEVER;
    }
}
